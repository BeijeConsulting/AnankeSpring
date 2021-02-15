//package it.beije.ananke.ecommerce;
//
//import java.io.IOException;
//import javax.servlet.ServletException;
//import javax.servlet.annotation.WebServlet;
//import javax.servlet.http.HttpServlet;
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import javax.servlet.http.HttpSession;
//
///**
// * Servlet implementation class OrderServlet
// */
//@WebServlet("/OrderServlet")
//public class OrderServlet extends HttpServlet {
//	private static final long serialVersionUID = 1L;
//       
//    /**
//     * @see HttpServlet#HttpServlet()
//     */
//    public OrderServlet() {
//        super();
//        // TODO Auto-generated constructor stub
//    }
//
//	/**
//	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		JPAmanager jpa = new JPAmanager();
//		int quantity = Integer.parseInt(request.getParameter("qnt"));
//		int idProduct = Integer.parseInt(request.getParameter("id"));
//		OrderItem orderItem = new OrderItem();
//		orderItem.setQuantity(quantity);
//		orderItem.setProduct_id(idProduct);
//		Product product = new Product();
//		product = jpa.findProduct(idProduct);
//		orderItem.setAmount(product.getPrice()*quantity);
//	}
//
//	/**
//	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
//	 */
//	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
//		// TODO Auto-generated method stub
//		doGet(request, response);
//	}
//
//}
