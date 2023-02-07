package board;

import java.util.List;

import board.vo.Board;
import board.vo.BoardSch;

// board.A03_Dao
public interface A03_Dao {
	public List<Board> boardList(BoardSch sch);
	public void insertBoard(Board ins);
	public Board getBoard(int no);	
	public void uptReadCnt(int no);	
}
