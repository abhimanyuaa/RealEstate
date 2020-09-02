package com.example.demo.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.Model.Contact;
import com.example.demo.Model.Package;
import com.example.demo.Model.PackageFeatures;
import com.example.demo.Model.PropertyAmenities;
import com.example.demo.Model.PropertyType;
import com.example.demo.Model.User;
import com.example.demo.Repository.UserRepository;
import com.example.demo.Service.ContactService;
import com.example.demo.Service.PackageFeaturesService;
import com.example.demo.Service.PackageService;
import com.example.demo.Service.PropertyAmenitiesService;
import com.example.demo.Service.PropertyTypeService;
import com.example.demo.Service.UserService;

@Controller
@RequestMapping("/Admin")
public class AdminController {

	@Autowired
	UserRepository userRepository;
	@Autowired
	UserService userService;
	@Autowired
	PropertyTypeService typeService;
	@Autowired
	PackageFeaturesService packageFeaturesService;
	@Autowired
	PackageService packageService;
	@Autowired
	PropertyAmenitiesService amenitiesService;
	@Autowired
	ContactService contactService;
	
	
	@RequestMapping("/AdminDashBoard")
	public String AdminHome(Model model) {

		return "/Admin/index";
	}

	@RequestMapping("/adminlogin")
	public String adminloginpage() {

		return "/Admin/adminlogin";
	}

	// Access Denied
	@RequestMapping("/access-denied")
	public String access_denied(RedirectAttributes attributes) {
		attributes.addFlashAttribute("error", true);
		attributes.addFlashAttribute("message", "You Don't have permission");
		return "redirect:/Admin/error-404";
	}

	@RequestMapping("/error-404")
	public String error_404() {
		return "websites/error";

	}

	@RequestMapping("/adminlogout")
	public String adminlogoutpage() {

		return "/Admin/adminlogout";
	}

	// save new Admin User
	@RequestMapping("/addAdmin")
	public String registerUser() {

		return "/Admin/registerAdmin";
	}

	// save new Admin User
	@RequestMapping("/saveNewAdmin")
	public String registerNewUser(@ModelAttribute User user) {
		user.setRoles("ROLE_ADMIN");
		userService.saveNewUser(user);
		return "/Admin/index";

	}

	// view All user in admin Panel
	@RequestMapping("/viewAllUser")
	public String viewAllUser(Model model, @PageableDefault(size = 5) Pageable pageable) {
		Page<User> pages = userService.findAll(pageable);
		model.addAttribute("page", pages);
		return "/Admin/viewAllUser";
	}

	// Manage Property Type 1BHK,2BHK,1RK
	@RequestMapping("/add-property-type")
	public String getPropertyType(Model model) {
		return "/Admin/addpropertyType";
	}

	@RequestMapping("/save-property")
	public String saveCategory(@ModelAttribute PropertyType type) {
		type.setTypeUrl(type.getTypeName().replace(" ", "-"));
		typeService.savePropertyType(type);
		return "/Admin/index";
	}
	

	// Package Management
	@RequestMapping("/addPackageFeatures")
	public String addPackageFeatures(PackageFeatures feature,Model model) {
		List<PackageFeatures> pl= packageFeaturesService.showAllPackageFeatures();
		model.addAttribute("listpkg",pl);
		return "/Admin/addPackageFeatures";
	}

	@RequestMapping("/save-packageFeature")
	public String savePackageFeature(PackageFeatures feature,Model model) {

		packageFeaturesService.savePackageFeatures(feature);
		List<PackageFeatures> pl= packageFeaturesService.showAllPackageFeatures();
		model.addAttribute("listpkg",pl);
		return "/Admin/addPackageFeatures";
	}

	
	@RequestMapping("/add-new-package")
	public String addNewPackage(Model model) {
		List<PackageFeatures> pl= packageFeaturesService.showAllPackageFeatures();
		model.addAttribute("listpkg",pl);
		model.addAttribute("package",new Package());
		return "/Admin/addPackage";
	}
	
	
	@RequestMapping("/save-new-package")
	public String saveNewPackage(Package pack) {
		
		packageService.savePackage(pack);
		return "/Admin/index";
	}
	
	@RequestMapping("/view-package")
	public String getAllPackages( Model model,@PageableDefault(size = 5) Pageable pageable)
	{
		Page<Package> pl=packageService.findAllPackage(pageable);
	model.addAttribute("page",pl);
		return "/Admin/viewAllPackage";
	}
	
	// Manage Property Amenities
	@RequestMapping("/add-property-Amenities")
	public String AddpropertyAmenities(Model model) {
		return "/Admin/addPropertyAmenities";
	}

	@RequestMapping("/save-property-Amenities")
	public String saveAmenity(@ModelAttribute PropertyAmenities aminities,Model model) {
		aminities.setAmenityName(aminities.getAmenityName().replace(" ", " "));
		amenitiesService.savePropertyAmenites(aminities);
		List<PropertyAmenities> pl= amenitiesService.showAllPropertyAmenities();
		model.addAttribute("listAmenity",pl);
		return "/Admin/addPropertyAmenities";
	}
	
	@RequestMapping("/viewAllContact")
	public String getAllContactMessages( Model model,@PageableDefault(size = 5) Pageable pageable)
	{
		Page<Contact> pl=contactService.findAllContact(pageable);
		model.addAttribute("page",pl);
		return "/Admin/viewAllContact";
	}
	
}
