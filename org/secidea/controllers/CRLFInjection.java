public class CRLFInjection {
    public String escapeInput(String input) {
        return HttpUtility.escapeHtml(input);
    }

    public void crlf(HttpServletRequest request, HttpServletResponse response) {
        response.addHeader("test1", escapeInput(request.getParameter("test1")));
        response.setHeader("test2", escapeInput(request.getParameter("test2")));
        String author = escapeInput(request.getParameter("test3"));
        Cookie cookie = new Cookie("test3", author);
        response.addCookie(cookie);
    }
}
