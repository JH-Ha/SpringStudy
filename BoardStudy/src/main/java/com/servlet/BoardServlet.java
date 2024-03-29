package com.servlet;

import com.dao.BoardDao;
import com.dao.DaoFactory;
import com.entity.Article;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * Servlet implementation class BoardServlet
 */
//@WebServlet("/board")
public class BoardServlet extends HttpServlet {

  private static final long serialVersionUID = 1L;

  /**
   * @see HttpServlet#HttpServlet()
   */
  public BoardServlet() {
    super();
    // TODO Auto-generated constructor stub
  }

  /**
   * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doGet(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    // response.getWriter().append("Served at: ").append(request.getContextPath());

    BoardDao boardDao =  new DaoFactory().boardDao();

    List<Article> boardList = boardDao.getBoardList();
    request.setAttribute("boardList", boardList);
    RequestDispatcher rd = request.getRequestDispatcher("board.jsp");
    rd.forward(request, response);
  }

  /**
   * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
   */
  protected void doPost(HttpServletRequest request, HttpServletResponse response)
      throws ServletException, IOException {
    // TODO Auto-generated method stub
    doGet(request, response);
  }

}
