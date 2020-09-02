package com.example.demo.Controller;

import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import org.springframework.data.web.PageableDefault;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import org.springframework.web.bind.annotation.ResponseBody;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.User;
import com.example.demo.Repository.ContactRepository;
import com.example.demo.Repository.OrderPackageRepository;
import com.example.demo.Repository.OrderResponseRepository;
import com.example.demo.Service.OrderPackageService;
import com.example.demo.Service.PackageService;
import com.example.demo.Service.PropertyService;
import com.example.demo.Service.PropertyTypeService;
import com.example.demo.Service.UserService;

import com.example.demo.Model.Contact;
import com.example.demo.Model.OrderPackage;
import com.example.demo.Model.OrderRequest;
import com.example.demo.Model.OrderResponse;
import com.example.demo.Model.Property;
import com.example.demo.Model.PropertyType;

import com.example.demo.Model.Package;

@Controller
public class HomeController {
	@Autowired
	UserService userService;
	@Autowired
	ContactRepository contactRepository;
	@Autowired
	PropertyService propertyService;
	@Autowired
	PropertyTypeService propertyTypeService;
	@Autowired
	PackageService packageService;
	@Autowired
	OrderPackageService orderPackageService;
	@Autowired
	OrderPackageRepository orderPackageRepository;
	@Autowired
	OrderResponseRepository orderResponseRepository;

	public static String uploadDirectory = System.getProperty("user.dir")
			+ "/src/main/resources/static/uploads/profilePhoto";

// get Current User Object
	public User getCurrentUser() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		User u = userService.getUserByUsername(username);
		return u;
	}

	// get All Property Type
	@RequestMapping("/fetch-all-propertyType")
	@ResponseBody
	public List<PropertyType> getAllCategories() {

		return propertyTypeService.showAllPropertyType();
	}

	@RequestMapping(value = "/")
	public String homepage(Model model, @PageableDefault(size = 3) Pageable pageable) {

		Page<Property> pages = propertyService.findAll(pageable);
		List<PropertyType> list = propertyTypeService.showAllPropertyType();
		model.addAttribute("serchType", list);
		model.addAttribute("page", pages);
	
		return "index";
	}

	@RequestMapping("/login")
	public String loginpage() {
		return "login";
	}

	@RequestMapping("/register")
	public String registerUser() {

		return "registerUser";
	}

	@RequestMapping(value = "/saveUser", method = RequestMethod.POST)
	// @RequestParam("profilePhoto") MultipartFile profilePhoto,
	public String registerNewUser(User user, BindingResult bindingResult) {

	
		userService.saveNewUser(user);
		return "redirect:/login";
	}

	@RequestMapping("/my-profile")
	public String getUserProfile() {
		return "myProfile";
	}

	// Access Denied
	@RequestMapping("/access-denied")
	public String access_denied(RedirectAttributes attributes) {
		attributes.addFlashAttribute("error", true);
		attributes.addFlashAttribute("message", "You Don't have permission");
		return "redirect:/error-404";
	}

	@RequestMapping("/error-404")
	public String error_404() {
		return "websites/error";

	}

	@RequestMapping("/logout")
	public String logout() {

		return "logout";
	}

	@RequestMapping("/logoutpage")
	public String logoutPage() {

		return "logout";
	}

	@RequestMapping("/faq")
	public String faqpage() {
		return "faq";
	}

	@RequestMapping("/contact")
	public String contactpage() {
		return "contact";
	}

	@RequestMapping(value = "/saveContactMessag")
	public String saveContactMessage(@ModelAttribute Contact contact) {
		contactRepository.save(contact);

		return "index";
	}

	@RequestMapping(value = "/Buy-Package")
	public String buyPackage(Model model) {
		List<Package> pl = packageService.findAllPackage();
		model.addAttribute("msg", "new");
		model.addAttribute("pkgList", pl);
		model.addAttribute("package", pl);
		return "buyPackage";
	}

	@RequestMapping("/Buy-Now")
	public String BuyPackage(Package pkg, Principal user, Model model)
			throws InvalidKeyException, NoSuchAlgorithmException {
		if (user != null) {
			User u = getCurrentUser();
			OrderPackage ord = new OrderPackage();
			Package pack = packageService.getPackageById(pkg.getPackageId());
			ord.setPackageName(pack.getPackageName());
			ord.setPackagePrice(pack.getPackagePrice());
			ord.setPackageId(pack.getPackageId());
			ord.setPackagePropertyCount(pack.getPackagePropertyCount());
			OrderRequest ordReq = orderPackageService.saveOrder(ord, u.getId());
			model.addAttribute("signature", ordReq.getSignature());
			model.addAttribute("postData", ordReq.getPostData());
			return "/OrderRequest";
		} else {
			return "login";
		}
	}

	@RequestMapping("/OrderResponse")
	public String signatureVerification(HttpServletRequest request, Model model, Principal user)
			throws NoSuchAlgorithmException, InvalidKeyException {
		// Response
		String id=request.getParameter("orderId");
		String amount=request.getParameter("orderAmount");
		String status=request.getParameter("txStatus");
		String refrencId=request.getParameter("referenceId");
		
		
		String signature = request.getParameter("signature");
		OrderResponse ordResponse = new OrderResponse(request.getParameter("orderId"),
				request.getParameter("orderAmount"), request.getParameter("referenceId"),
				request.getParameter("txStatus"), request.getParameter("paymentMode"), request.getParameter("txMsg"),
				request.getParameter("txTime"));
		String computedSignature = orderPackageService.getCoumputedSignature(ordResponse,
				request.getParameter("signature"));
		// System.out.println(ordResponse);
		// System.out.println("computed " +computedSignature);
		// System.out.println("Generated "+signature);
		User u = getCurrentUser();
		String name = u.getFirstName();
		System.out.println("name is" + u.getFirstName());
		if (signature.equals(computedSignature)) {
			// System.out.println("Sucess Transaction");
			OrderPackage Ord = orderPackageRepository.getByOrderCode(request.getParameter("orderId"));
			Ord.setTxStatus(request.getParameter("txStatus"));
			Ord.setTxTime(request.getParameter("txTime"));
			orderPackageRepository.save(Ord);
			orderResponseRepository.save(ordResponse);

			// System.out.println("Main Order After Response" + Ord);

			return "OrderResponse";
		} else {
			// System.out.println("Failed Transaction");
			
			OrderPackage Ord = orderPackageRepository.getByOrderCode(request.getParameter("orderId"));
			Ord.setTxStatus(request.getParameter("txStatus"));
			Ord.setTxTime(request.getParameter("txTime"));
			orderPackageRepository.save(Ord);
			orderResponseRepository.save(ordResponse);
			// System.out.println("Main Order After Response" + Ord);
			model.addAttribute("username", name);
			
			return "OrderResponse";
		}
	}

	

}
