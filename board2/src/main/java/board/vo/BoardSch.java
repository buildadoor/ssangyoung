package board.vo;
// board.vo.BoardSch
public class BoardSch {
// 1. 검색
 private String subject;
 private String writer;
// 2. 페이징 처리 	1단계
 private int count; //전체 데이터 건수
 private int pageSize; //한 페이지에 보여줄 페이지 크기
 private int pageCount; //총 페이지 수 count/pageSize
 private int curPage; //클릭한 현재 페이지 번호
 private int start; // 현재 페이지 시작 번호
 private int end; // 현재 페이지 마지막 번호
 // 3. 페이징 처리 2단계(블럭)
 private int blockSize; // 한번에 보여줄 block의 크기
 private int startBlock; // block 시작번호
 private int endBlock; // block 마지막번호
 
 
public int getBlockSize() {
	return blockSize;
}
public void setBlockSize(int blockSize) {
	this.blockSize = blockSize;
}
public int getStartBlock() {
	return startBlock;
}
public void setStartBlock(int startBlock) {
	this.startBlock = startBlock;
}
public int getEndBlock() {
	return endBlock;
}
public void setEndBlock(int endBlock) {
	this.endBlock = endBlock;
}
public BoardSch(String subject, String writer) {
	this.subject = subject;
	this.writer = writer;
}
public String getSubject() {
	return subject;
}
public void setSubject(String subject) {
	this.subject = subject;
}
public String getWriter() {
	return writer;
}
public void setWriter(String writer) {
	this.writer = writer;
}
public int getCount() {
	return count;
}
public void setCount(int count) {
	this.count = count;
}
public int getPageSize() {
	return pageSize;
}
public void setPageSize(int pageSize) {
	this.pageSize = pageSize;
}
public int getPageCount() {
	return pageCount;
}
public void setPageCount(int pageCount) {
	this.pageCount = pageCount;
}
public int getCurPage() {
	return curPage;
}
public void setCurPage(int curPage) {
	this.curPage = curPage;
}
public int getStart() {
	return start;
}
public void setStart(int start) {
	this.start = start;
}
public int getEnd() {
	return end;
}
public void setEnd(int end) {
	this.end = end;
}
 
}
