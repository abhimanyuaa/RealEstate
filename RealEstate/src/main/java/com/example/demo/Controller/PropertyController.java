package com.example.demo.Controller;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.Principal;
import java.util.List;
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
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import com.example.demo.Model.OrderPackage;
import com.example.demo.Model.Package;
import com.example.demo.Model.Property;
import com.example.demo.Model.PropertyAmenities;
import com.example.demo.Model.PropertyType;
import com.example.demo.Model.SearchProperty;
import com.example.demo.Model.User;
import com.example.demo.Repository.OrderPackageRepository;
import com.example.demo.Service.EmailService;
import com.example.demo.Service.OrderPackageService;
import com.example.demo.Service.PackageService;
import com.example.demo.Service.PropertyAmenitiesService;
import com.example.demo.Service.PropertyService;
import com.example.demo.Service.PropertyTypeService;
import com.example.demo.Service.UserService;

@Controller
@RequestMapping("/property")
public class PropertyController {
	@Autowired
	PropertyService propertyService;
	@Autowired
	UserService userService;
	@Autowired
	PropertyTypeService propertyTypeService;
	@Autowired
	PropertyAmenitiesService amenitiesService;
	@Autowired
	OrderPackageService orderPackageService;
	@Autowired
	PackageService packageService;
	@Autowired
	OrderPackageRepository orderPackageRepository;
	@Autowired
	EmailService emailService;
	

	public static String uploadDirectory = System.getProperty("user.dir")
			+ "/src/main/resources/static/uploads/property";

	// get Current User Object
	public User getCurrentUser() {
		Authentication loggedInUser = SecurityContextHolder.getContext().getAuthentication();
		String username = loggedInUser.getName();
		User u = userService.getUserByUsername(username);
		return u;
	}

	//add property 
	@RequestMapping(value = "/add-property")
	public String AddnewProperty(Principal user, Model model) {
		if (user != null) {
			List<PropertyType> typelist = propertyTypeService.showAllPropertyType();
			model.addAttribute("type", typelist);
			List<PropertyAmenities> pl = amenitiesService.showAllPropertyAmenities();
			model.addAttribute("listAmenity", pl);
			model.addAttribute("prop", new Property());
			return "addProperty";
		} else {
			return "redirect:/login";
		}
	}

	//save Property
	@RequestMapping(value = "/save-new-property", method = RequestMethod.POST)
	public String saveProperty(Property property, BindingResult bindingResult, Principal user,
			@RequestParam("propertyImage1") MultipartFile propertyImage1,
			@RequestParam("propertyImage2") MultipartFile propertyImage2,
			@RequestParam("propertyImage3") MultipartFile propertyImage3,
			@RequestParam("propertyImage4") MultipartFile propertyImage4,
			@RequestParam("propertyImage5") MultipartFile propertyImage5,
			@RequestParam("propertyImage6") MultipartFile propertyImage6,
			@RequestParam("propertyImage7") MultipartFile propertyImage7,
			@RequestParam("propertyImage8") MultipartFile propertyImage8,
			@RequestParam("propertyImage9") MultipartFile propertyImage9,
			@RequestParam("propertyImage10") MultipartFile propertyImage10, Pageable pageable, Model model)
			throws IOException {

		if (user != null) {

			User u = getCurrentUser();

			String id = Integer.toString(u.getId());

			if (!propertyImage1.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage1.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage1.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage1(id + propertyImage1.getOriginalFilename());
			}
			if (!propertyImage2.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage2.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage2.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage2(id + propertyImage2.getOriginalFilename());
			}
			if (!propertyImage3.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage3.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage3.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage3(id + propertyImage3.getOriginalFilename());
			}

			if (!propertyImage4.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage4.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage4.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage4(id + propertyImage4.getOriginalFilename());
			}

			if (!propertyImage5.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage5.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage5.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage5(id + propertyImage5.getOriginalFilename());
			}

			if (!propertyImage6.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage6.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage6.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage6(id + propertyImage6.getOriginalFilename());
			}

			if (!propertyImage7.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage7.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage7.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage7(id + propertyImage7.getOriginalFilename());
			}

			if (!propertyImage8.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage8.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage8.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage8(id + propertyImage8.getOriginalFilename());
			}

			if (!propertyImage9.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage9.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage9.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage9(id + propertyImage9.getOriginalFilename());
			}

			if (!propertyImage10.isEmpty()) {
				Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage10.getOriginalFilename());
				try {
					Files.write(fileNameAndPath, propertyImage10.getBytes());
				} catch (IOException e) {
					e.printStackTrace();
				}
				property.setPropertyImage10(id + propertyImage10.getOriginalFilename() );
			}
			property.setUserId(u.getId());

			propertyService.saveProperty(property);
			Page<Property> pages = propertyService.findAllPropertyByUserId(u.getId(), pageable);

			model.addAttribute("page", pages);
			return "redirect:/property/my-properties";

		} else {
			return "login";
		}
	}

	//edit Property
	@RequestMapping(value = "/edit-property")
	public String editProperty(@RequestParam String Url, Model model) {
		List<PropertyType> typelist = propertyTypeService.showAllPropertyType();
		List<PropertyAmenities> pl = amenitiesService.showAllPropertyAmenities();
		model.addAttribute("type", typelist);
		model.addAttribute("listAmenity", pl);
		model.addAttribute("prop",  propertyService.getPropertyByPropertyUrl(Url));

		return "editProperty";
	}

	//save edited Property
	@RequestMapping(value = "/save-edited-property")
	public String saveEditedProperty(@ModelAttribute Property property, BindingResult bindingResult, Principal user,
			@RequestParam("propertyImage1") MultipartFile propertyImage1,
			@RequestParam("propertyImage2") MultipartFile propertyImage2,
			@RequestParam("propertyImage3") MultipartFile propertyImage3,
			@RequestParam("propertyImage4") MultipartFile propertyImage4,
			@RequestParam("propertyImage5") MultipartFile propertyImage5,
			@RequestParam("propertyImage6") MultipartFile propertyImage6,
			@RequestParam("propertyImage7") MultipartFile propertyImage7,
			@RequestParam("propertyImage8") MultipartFile propertyImage8,
			@RequestParam("propertyImage9") MultipartFile propertyImage9,
			@RequestParam("propertyImage10") MultipartFile propertyImage10, Pageable pageable, Model model) {
		User u = getCurrentUser();
		String id = Integer.toString(u.getId());
		System.out.println("before "+property.getPropertyImage4());
		if (!propertyImage1.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage1.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage1.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage1(id + propertyImage1.getOriginalFilename());
		}
		if (!propertyImage2.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage2.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage2.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage2(id + propertyImage2.getOriginalFilename());
		}
		if (!propertyImage3.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage3.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage3.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
		
			property.setPropertyImage3(id + propertyImage3.getOriginalFilename());
		
		}

		if (!propertyImage4.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage4.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage4.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage4(id + propertyImage4.getOriginalFilename());
			System.out.println("After"+property.getPropertyImage4());
		}

		if (!propertyImage5.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage5.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage5.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage5(id + propertyImage5.getOriginalFilename());
			
		}

		if (!propertyImage6.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage6.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage6.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage6(id + propertyImage6.getOriginalFilename());
		}

		if (!propertyImage7.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage7.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage7.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage7(id + propertyImage7.getOriginalFilename());
		}

		if (!propertyImage8.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage8.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage8.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage8(id + propertyImage8.getOriginalFilename());
		}

		if (!propertyImage9.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage9.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage9.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage9(id + propertyImage9.getOriginalFilename());
			}

		if (!propertyImage10.isEmpty()) {
			Path fileNameAndPath = Paths.get(uploadDirectory, id + propertyImage10.getOriginalFilename());
			try {
				Files.write(fileNameAndPath, propertyImage10.getBytes());
			} catch (IOException e) {
				e.printStackTrace();
			}
			property.setPropertyImage10(id + propertyImage10.getOriginalFilename() );
		
			}
		property.setUserId(u.getId());
		propertyService.saveEditedPropety(property);
		return "redirect:/property/my-properties";
	}

	//delete Property 
	@RequestMapping(value = "/delete-property")
	public String deleteProperty( @RequestParam String Url) {
		propertyService.deletePropertyByUrl(Url);
		return "redirect:/property/my-properties";
	}

	//Display Single Property
	@RequestMapping(value = "/single-property")
	public String singlePropertyDisplay(@RequestParam String Url, Model model) {

		User u = getCurrentUser();
		if (u != null) {
			Property property = propertyService.getPropertyByPropertyUrl(Url);
			property.setUserId(u.getId());

			model.addAttribute("property", property);
			model.addAttribute("user", u);

			return "singleProperty";
		} else {
			Property property = propertyService.getPropertyByPropertyUrl(Url);
			model.addAttribute("property", property);
			return "singleProperty";
		}
	}

	
	//Display My Properties
	@RequestMapping("/my-properties")
	public String getMyProperties(Principal user, Model model, @PageableDefault(size = 4) Pageable pageable) {
		if (user != null) {
			User u = getCurrentUser();
			Page<Property> pages = propertyService.findAllPropertyByUserId(u.getId(), pageable);
			model.addAttribute("page", pages);
			return "myProperties";
		} else {
			return "redirect:/login";
		}
	}

	//Display Property by Type
	@RequestMapping("/propeties/{data}")
	public String getSerchedProperty(Model model, @PathVariable(value = "data") String data,
			@PageableDefault(size = 3) Pageable pageable) {
		Page<Property> pages = propertyService.findAllPropertyByPropertyType(data, pageable);
		model.addAttribute("page", pages);
		return "properties";
	}

	// get Contact Owner Information
	@RequestMapping(value = "/getOwnerInformation", method = RequestMethod.POST)
	public @ResponseBody boolean getOwnerInfo(@RequestParam Integer clickcount, Model model)
			throws InvalidKeyException, NoSuchAlgorithmException {
		User u = getCurrentUser();
		int userId = u.getId();
		OrderPackage ord = orderPackageService.getOrderByUId(userId);
		int count = Integer.parseInt(ord.getPackagePropertyCount());

		if (count > 0) {
			count = Integer.parseInt(ord.getPackagePropertyCount());
			System.out.println("Db " + count);

			System.out.println("send mail");
			int latestCount = count - clickcount;
			String lastCount = String.valueOf(latestCount);
			System.out.println("latestCount" + latestCount);
			ord.setPackagePropertyCount(lastCount);
			orderPackageRepository.save(ord);
			return true;
		} else {
		
			boolean b = emailService.sendMail("hefshine.abhimanyu@gmail.com", "t", "Please Upgrade your Package");
			System.out.println("in zero count with b" + b);
			return false;
		}

	}

	// Call Buy Packag Page
	public String buyPackage(Model model) {
		List<Package> pl = packageService.findAllPackage();
		model.addAttribute("pkgList", pl);
		model.addAttribute("package", pl);
		// boolean b = emailService.sendMail("hefshine.abhimanyu@gmail,com", "Test",
		// "ok");
		return "buyPackage";
	}

	// search Property
	@RequestMapping(value = "/search-Property")
	public String getSerchedProperty(@ModelAttribute SearchProperty search,
			@PageableDefault(size = 3) Pageable pageable, Model model) {

		Page<Property> pages = propertyService.findAllPropertyBySearchUrl(search, pageable);
		model.addAttribute("page", pages);
		return "SearchProperties";
	}
	
	// Favorite Property
	@RequestMapping(value = "/myFavorite")
	public String getFavoriteProperty(@RequestParam String Url,Principal user) {
		User u = getCurrentUser();
		if (u != null) {
			System.out.println("url is " + Url);
			Property p=propertyService.getPropertyByPropertyUrl(Url);
			
		return "redirect:/";
		}
		else
		{
			return "redirect:/";
		}
	}
}
