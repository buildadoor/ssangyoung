

public void Buy(String userno) {
       try {
          con = DB.con();
            con.setAutoCommit(false);
       String sql0="SELECT count(*) FROM buy\r\n"
             + "WHERE userno = ?\r\n"
             + "AND payment_status='결제대기'";
               pstmt = con.prepareStatement(sql0);
               pstmt.setString(1, userno);
               rs = pstmt.executeQuery();   
               rs.next();
               int falsebuy=rs.getInt(1);
               System.out.println(falsebuy);
      if(falsebuy==0) {
         String sql6 = "SELECT p.PRODUCTNAME, b.BUYCOUNT, b.TOTPRICE  FROM buycart b,PRODUCT p \r\n"
               + "WHERE b.ISBN =p.ISBN \r\n"
               + "AND USERNO =?";
         pstmt = con.prepareStatement(sql6);
         pstmt.setString(1, userno);
         rs = pstmt.executeQuery();
         System.out.println("------------<"+userno+"님의 장바구니 목록>------------");
         while(rs.next()) {
            System.out.print("<구매품명:"+rs.getString(1)+" | ");
            System.out.print("구매갯수:"+rs.getInt(2)+" | ");
            System.out.println("총 가격"+rs.getInt(3)+">");
         }
         System.out.println("------------------------------------------------");
         con.commit();
         
         System.out.println("장바구니 목록중 삭제할 물품이 있으시다면, 취소 후 장바구니 목록삭제 후, 다시 이용바랍니다.");
         System.out.println("삭제할 물품이 있으십니까? (1.예 2.아니오)");
         System.out.print("번호입력:");
         int nextlevel=scan.nextInt();
         if(nextlevel==1) {
       String sql="INSERT INTO buy values('buy-'||?||buy_seq.nextval,?,sysdate,'결제대기')";
         pstmt = con.prepareStatement(sql);
         
         pstmt.setString(1, userno+"-");
         pstmt.setString(2, userno);
         rs = pstmt.executeQuery();
         con.commit();
         
         
         
         String sql2="INSERT INTO buylist\r\n"
               + "SELECT b.buynum||'-'||buylist_seq.nextval,b.buynum,b2.ISBN,b2.BUYCOUNT,b2.TOTPRICE \r\n"
               + "FROM buy b,BUYCART b2,PRODUCT p\r\n"
               + "WHERE b.userno=b2.USERNO\r\n"
               + "AND p.ISBN = b2.ISBN \r\n"
               + "AND b.payment_status ='결제대기'";

         
         pstmt = con.prepareStatement(sql2);
         rs = pstmt.executeQuery();
         con.commit();
         
      String sql3="SELECT sum(b.price) FROM buylist b,buy b2\r\n"
            + "WHERE b.buynum=b2.buynum\r\n"
            + "AND b2.payment_status='결제대기'";
      pstmt = con.prepareStatement(sql3);
      rs = pstmt.executeQuery();
         rs.next();
         int totalpay=rs.getInt(1);
         System.out.println("<"+userno+"님의 주문 총 금액은"+totalpay+"원입니다.>");
         System.out.println("<바로 결제하시겠습니까? (1.예 2.아니오) >");
         int SelectPayment = scan.nextInt();
         if(SelectPayment==1) {
            String sql4="UPDATE buy\r\n"
                  + "SET payment_status =?\r\n"
                  + "WHERE userno =?\r\n"
                  + "AND payment_status='결제대기'";
            System.out.println("결제방식을 선택해주세요. (1.카드결제 2.계좌이체)");
            System.out.print("번호입력:");
            int SelectPayment2 = scan.nextInt();
            if(SelectPayment2==1) {ChoicePayment="결제완료(카드)";}
         else if(SelectPayment2==2) {ChoicePayment="결제완료(계좌이체)";}
            pstmt = con.prepareStatement(sql4);
            pstmt.setString(1, ChoicePayment);
            pstmt.setString(2, userno);
            rs = pstmt.executeQuery();
            con.commit();
            System.out.println(YELLOW+"최종주문 및 결제가 완료 되었습니다. 감사합니다!"+RESET);
         }
         else {System.out.println(YELLOW+"주문이 완료 되었습니다. 감사합니다! 결제는 '결제하기'를 이용바랍니다."+RESET);
            System.out.println("결재 대기중인 목록이 있을 경우, 장바구니목록 추가는 불가하니 참고바랍니다.");}
         
         
         String sql5="DELETE buycart\r\n"
               + "WHERE userno=?";
         
         pstmt = con.prepareStatement(sql5);
         pstmt.setString(1, userno);

         rs = pstmt.executeQuery();
         con.commit();
         }
      } else {System.out.println("현재 결재 대기중인 항목이 있습니다. 결재후 다시 이용바랍니다.");
      }
      } catch (SQLException e) {
         System.out.println("DB처리:" + e.getMessage());
         try {
            con.rollback();
         } catch (SQLException e1) {
            System.out.println("rollback에러:" + e1.getMessage());
         }
      } catch (Exception e) {
         System.out.println("기타예외:" + e.getMessage());
      } finally {
         DB.close(rs, stmt, con);
      }
         
    }