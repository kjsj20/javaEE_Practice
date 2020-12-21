/*
 * Generated by the Jasper component of Apache Tomcat
 * Version: Apache Tomcat/8.5.61
 * Generated at: 2020-12-21 16:07:52 UTC
 * Note: The last modified time of this file was set to
 *       the last modified time of the source file after
 *       generation to assist with modification tracking.
 */
package org.apache.jsp.board;

import javax.servlet.*;
import javax.servlet.http.*;
import javax.servlet.jsp.*;
import com.board.domain.Board;
import com.board.util.Pager;
import java.util.List;

public final class list_jsp extends org.apache.jasper.runtime.HttpJspBase
    implements org.apache.jasper.runtime.JspSourceDependent,
                 org.apache.jasper.runtime.JspSourceImports {

  private static final javax.servlet.jsp.JspFactory _jspxFactory =
          javax.servlet.jsp.JspFactory.getDefaultFactory();

  private static java.util.Map<java.lang.String,java.lang.Long> _jspx_dependants;

  private static final java.util.Set<java.lang.String> _jspx_imports_packages;

  private static final java.util.Set<java.lang.String> _jspx_imports_classes;

  static {
    _jspx_imports_packages = new java.util.HashSet<>();
    _jspx_imports_packages.add("javax.servlet");
    _jspx_imports_packages.add("javax.servlet.http");
    _jspx_imports_packages.add("javax.servlet.jsp");
    _jspx_imports_classes = new java.util.HashSet<>();
    _jspx_imports_classes.add("java.util.List");
    _jspx_imports_classes.add("com.board.domain.Board");
    _jspx_imports_classes.add("com.board.util.Pager");
  }

  private volatile javax.el.ExpressionFactory _el_expressionfactory;
  private volatile org.apache.tomcat.InstanceManager _jsp_instancemanager;

  public java.util.Map<java.lang.String,java.lang.Long> getDependants() {
    return _jspx_dependants;
  }

  public java.util.Set<java.lang.String> getPackageImports() {
    return _jspx_imports_packages;
  }

  public java.util.Set<java.lang.String> getClassImports() {
    return _jspx_imports_classes;
  }

  public javax.el.ExpressionFactory _jsp_getExpressionFactory() {
    if (_el_expressionfactory == null) {
      synchronized (this) {
        if (_el_expressionfactory == null) {
          _el_expressionfactory = _jspxFactory.getJspApplicationContext(getServletConfig().getServletContext()).getExpressionFactory();
        }
      }
    }
    return _el_expressionfactory;
  }

  public org.apache.tomcat.InstanceManager _jsp_getInstanceManager() {
    if (_jsp_instancemanager == null) {
      synchronized (this) {
        if (_jsp_instancemanager == null) {
          _jsp_instancemanager = org.apache.jasper.runtime.InstanceManagerFactory.getInstanceManager(getServletConfig());
        }
      }
    }
    return _jsp_instancemanager;
  }

  public void _jspInit() {
  }

  public void _jspDestroy() {
  }

  public void _jspService(final javax.servlet.http.HttpServletRequest request, final javax.servlet.http.HttpServletResponse response)
      throws java.io.IOException, javax.servlet.ServletException {

    final java.lang.String _jspx_method = request.getMethod();
    if (!"GET".equals(_jspx_method) && !"POST".equals(_jspx_method) && !"HEAD".equals(_jspx_method) && !javax.servlet.DispatcherType.ERROR.equals(request.getDispatcherType())) {
      response.sendError(HttpServletResponse.SC_METHOD_NOT_ALLOWED, "JSP들은 오직 GET, POST 또는 HEAD 메소드만을 허용합니다. Jasper는 OPTIONS 메소드 또한 허용합니다.");
      return;
    }

    final javax.servlet.jsp.PageContext pageContext;
    javax.servlet.http.HttpSession session = null;
    final javax.servlet.ServletContext application;
    final javax.servlet.ServletConfig config;
    javax.servlet.jsp.JspWriter out = null;
    final java.lang.Object page = this;
    javax.servlet.jsp.JspWriter _jspx_out = null;
    javax.servlet.jsp.PageContext _jspx_page_context = null;


    try {
      response.setContentType("text/html;charset=utf-8");
      pageContext = _jspxFactory.getPageContext(this, request, response,
      			null, true, 8192, true);
      _jspx_page_context = pageContext;
      application = pageContext.getServletContext();
      config = pageContext.getServletConfig();
      session = pageContext.getSession();
      out = pageContext.getOut();
      _jspx_out = out;

      out.write("\r\n");
      out.write("\r\n");
      out.write("\r\n");
      out.write(" \r\n");

	List<Board> list = (List)request.getAttribute("boardList");
	Pager pager = new Pager();
	pager.init(request, list);

      out.write("\r\n");
      out.write("<!DOCTYPE html>\r\n");
      out.write("<html>\r\n");
      out.write("<head>\r\n");
      out.write("<meta name=\"viewport\" content=\"width=device-width, initial-scale=1\">\r\n");
      out.write("<style>\r\n");
      out.write("table {\r\n");
      out.write("\tborder-collapse: collapse;\r\n");
      out.write("\tborder-spacing: 0;\r\n");
      out.write("\twidth: 100%;\r\n");
      out.write("\tborder: 1px solid #ddd;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("th, td {\r\n");
      out.write("\ttext-align: left;\r\n");
      out.write("\tpadding: 16px;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("tr:nth-child(even) {\r\n");
      out.write("\tbackground-color: #f2f2f2;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".regist {\r\n");
      out.write("  background-color: #4CAF50;\r\n");
      out.write("  color: white;\r\n");
      out.write("  padding: 12px 20px;\r\n");
      out.write("  border: none;\r\n");
      out.write("  border-radius: 4px;\r\n");
      out.write("  cursor: pointer;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".regist:hover {\r\n");
      out.write("  background-color: #45a049;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write("#blockPage {\r\n");
      out.write("\ttext-decoration : none;\r\n");
      out.write("}\r\n");
      out.write("\r\n");
      out.write(".curPage{\r\n");
      out.write("\tborder : 2px solid;\r\n");
      out.write("\tpadding : 3px;\r\n");
      out.write("}\r\n");
      out.write("</style>\r\n");
      out.write("</head>\r\n");
      out.write("<body>\r\n");
      out.write("\r\n");
      out.write("\t<table>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<th>No</th>\r\n");
      out.write("\t\t\t<th>제목</th>\r\n");
      out.write("\t\t\t<th>작성자</th>\r\n");
      out.write("\t\t\t<th>내용</th>\r\n");
      out.write("\t\t\t<th>작성일</th>\r\n");
      out.write("\t\t\t<th>조회수</th>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t");

			int curPos = pager.getCurPos();
			int num = pager.getNum();
		
      out.write("\r\n");
      out.write("\t\t");
for(int i = 1; i<pager.getPageSize() + 1; i++){ 
      out.write("\r\n");
      out.write("\t\t");
if(num<1)break; 
      out.write("\r\n");
      out.write("\t\t");
Board board = list.get(curPos++);
      out.write(" \r\n");
      out.write("\t\t\t<tr>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(num-- );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td><a href = \"/board/detail.do?board_id=");
      out.print(board.getBoard_id());
      out.write("&currentPage=");
      out.print(pager.getCurrentPage());
      out.write('"');
      out.write('>');
      out.print(board.getTitle() );
      out.write("</a></td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(board.getWriter() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(board.getContent() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(board.getRegdate() );
      out.write("</td>\r\n");
      out.write("\t\t\t\t<td>");
      out.print(board.getHit() );
      out.write("</td>\r\n");
      out.write("\t\t\t</tr>\r\n");
      out.write("\t\t");
} 
      out.write("\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"6\" style=\"text-align:center\">\r\n");
      out.write("\t\t\t\t<a id = \"blockPage\" href = \"/board/list.do?currentPage=");
      out.print(1);
      out.write("\">◀◀</a>\r\n");
      out.write("\t\t\t\t");
if(pager.getCurrentPage() > 1){
      out.write("\r\n");
      out.write("\t\t\t\t<a id = \"blockPage\" href = \"/board/list.do?currentPage=");
      out.print(pager.getFirstPage() - pager.getBlockSize());
      out.write("\">◀</a>\r\n");
      out.write("\t\t\t\t");
}else{ 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a id = \"blockPage\">◀</a>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t");
for(int i = pager.getFirstPage(); i < pager.getLastPage() + 1; i++){ 
      out.write("\r\n");
      out.write("\t\t\t\t");
if(pager.getTotalPage() < i)break; 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a id = \"blockPage\" ");
if(pager.getCurrentPage() == i){ 
      out.write("class = \"curPage\"");
} 
      out.write(" href = \"/board/list.do?currentPage=");
      out.print(i);
      out.write('"');
      out.write('>');
      out.print(i );
      out.write("</a>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t");
if(pager.getCurrentPage() == pager.getTotalPage()) {
      out.write("\r\n");
      out.write("\t\t\t\t\t<a id = \"blockPage\">▶</a>\r\n");
      out.write("\t\t\t\t");
} else { 
      out.write("\r\n");
      out.write("\t\t\t\t\t<a id = \"blockPage\" href = \"/board/list.do?currentPage=");
      out.print(pager.getLastPage() + 1);
      out.write("\">▶</a>\r\n");
      out.write("\t\t\t\t");
} 
      out.write("\r\n");
      out.write("\t\t\t\t<a id = \"blockPage\" href = \"/board/list.do?currentPage=");
      out.print(pager.getTotalPage());
      out.write("\">▶▶</a>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t\t<tr>\r\n");
      out.write("\t\t\t<td colspan=\"6\">\r\n");
      out.write("\t\t\t\t<button class = \"regist\" onClick=\"location.href='/board/regist_form.jsp'\">글등록</button>\r\n");
      out.write("\t\t\t</td>\r\n");
      out.write("\t\t</tr>\r\n");
      out.write("\t</table>\r\n");
      out.write("\r\n");
      out.write("</body>\r\n");
      out.write("</html>");
    } catch (java.lang.Throwable t) {
      if (!(t instanceof javax.servlet.jsp.SkipPageException)){
        out = _jspx_out;
        if (out != null && out.getBufferSize() != 0)
          try {
            if (response.isCommitted()) {
              out.flush();
            } else {
              out.clearBuffer();
            }
          } catch (java.io.IOException e) {}
        if (_jspx_page_context != null) _jspx_page_context.handlePageException(t);
        else throw new ServletException(t);
      }
    } finally {
      _jspxFactory.releasePageContext(_jspx_page_context);
    }
  }
}