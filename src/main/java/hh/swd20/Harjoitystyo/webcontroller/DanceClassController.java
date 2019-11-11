package hh.swd20.Harjoitystyo.webcontroller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import hh.swd20.Harjoitystyo.domain.ClassImplementation;
import hh.swd20.Harjoitystyo.domain.ClassImplementationRepository;
import hh.swd20.Harjoitystyo.domain.DanceClass;
import hh.swd20.Harjoitystyo.domain.DanceClassRepository;
import hh.swd20.Harjoitystyo.domain.Enrollment;
import hh.swd20.Harjoitystyo.domain.EnrollmentRepository;
import hh.swd20.Harjoitystyo.domain.StudentRepository;
import hh.swd20.Harjoitystyo.domain.Teacher;
import hh.swd20.Harjoitystyo.domain.TeacherRepository;


@Controller
public class DanceClassController {
	
	@Autowired
	private DanceClassRepository DCrepository;
	
	@Autowired
	private StudentRepository Srepository;
	
	@Autowired
	private TeacherRepository Trepository;
	
	@Autowired
	private ClassImplementationRepository CIrepository;
	
	@Autowired
	private EnrollmentRepository Erepository;

	@RequestMapping("/login")
	public String login(){
		return "LoginPage";
	}
	
	//List of classes
	@RequestMapping("/classes")
	public String classes(Model model) {
		model.addAttribute("classes", DCrepository.findAll());
		return "ClassesList";
	}
	
	//List of Implementations
	@RequestMapping("/implementations")
	public String implementations(Model model) {
		model.addAttribute("implementations", CIrepository.findAll());
		return "ClassImplementations";
	}
	
	//RESTful service: list of classes
	@RequestMapping(value="/restclasses", method = RequestMethod.GET)
    public @ResponseBody List<DanceClass> danceClassListRest() {	
        return (List<DanceClass>) DCrepository.findAll();
    }    

	// RESTful service: class by id
    @RequestMapping(value="/restclass/{id}", method = RequestMethod.GET)
    public @ResponseBody Optional<DanceClass> findDanceClassRest(@PathVariable("id") Long classId) {	
    	return DCrepository.findById(classId);
    } 
    
  //RESTful service: list of Implementations
  	@RequestMapping(value="/restimplementations", method = RequestMethod.GET)
      public @ResponseBody List<ClassImplementation> implementationsListRest() {	
          return (List<ClassImplementation>) CIrepository.findAll();
      }    

  	// RESTful service: implementation by id
    @RequestMapping(value="/restimplementation/{id}", method = RequestMethod.GET)
      public @ResponseBody Optional<ClassImplementation> findImplementationRest(@PathVariable("id") Long implementationId) {	
      	return CIrepository.findById(implementationId);
      } 
    
  //RESTful service: list of teachers
  	@RequestMapping(value="/restteachers", method = RequestMethod.GET)
      public @ResponseBody List<Teacher> teachersListRest() {	
          return (List<Teacher>) Trepository.findAll();
      }    

  	// RESTful service: teacher by id
    @RequestMapping(value="/restteacher/{id}", method = RequestMethod.GET)
      public @ResponseBody Optional<Teacher> findTeacherRest(@PathVariable("id") Long teacherId) {	
      	return Trepository.findById(teacherId);
      }  
    
    //Add new class 
	//Method level security - Admin only 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add/class")
	public String addDanceClass(Model model){
	model.addAttribute("class", new DanceClass());
	return "AddClass";
	}
	
	//Save new class
	//Method level security - Admin only 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/save/class", method = RequestMethod.POST)
	public String saveClass(DanceClass DanceClass){
	DCrepository.save(DanceClass);
	return "redirect:/classes";
	}
	
	//Edit implementation
	//Method level security - Admin only 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/edit/implementation/{id}")
	public String editImplementation(@PathVariable("id") Long implementationId, Model model){
	model.addAttribute("teachers", Trepository.findAll());
	model.addAttribute("implementation", CIrepository.findById(implementationId));
	model.addAttribute("danceClasses", DCrepository.findAll());
	return "EditImplementation";
	}
	
	//Add new implementation
	//Method level security - Admin only 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/add/implementation")
	public String addImplementation(Model model){
	model.addAttribute("teachers", Trepository.findAll());
	model.addAttribute("danceclasses", DCrepository.findAll());
	model.addAttribute("implementation", new ClassImplementation());
	return "AddImplementation";
	}
	
	//Save new implementation
	//Method level security - Admin only 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/save/implementation", method = RequestMethod.POST)
	public String saveImplementation(ClassImplementation implementation){
	CIrepository.save(implementation);
	return "redirect:/implementations";
	}
	
	//Enroll for implementation
	@RequestMapping(value = "/enroll")
	public String enroll(/*@PathVariable("id") Long implementationId,*/ Model model){
	//model.addAttribute("implementation", CIrepository.findById(implementationId));
	model.addAttribute("implementations", CIrepository.findAll());
	model.addAttribute("students", Srepository.findAll());
	model.addAttribute("enrollments", Erepository.findAll());
	model.addAttribute("enrollment", new Enrollment());
	return "EnrollForm";
	}
	
	//Submit enrollment
	@RequestMapping(value = "/submit", method = RequestMethod.POST)
	public String saveEnrollment(Enrollment enrollment){
	Erepository.save(enrollment);
	return "redirect:/implementations";
	}
	
	//Delete class by id
	//Method level security - Admin only 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/class/{id}", method = RequestMethod.GET)
	public String deleteDanceClass(@PathVariable("id") Long danceClassId, Model model) {
	DCrepository.deleteById(danceClassId);
	return "redirect:/classes";
	}
	
	//Delete implementation by id
	//Method level security - Admin only 
	@PreAuthorize("hasAuthority('ADMIN')")
	@RequestMapping(value = "/delete/implementation/{id}", method = RequestMethod.GET)
	public String deleteImplementation(@PathVariable("id") Long implementationId, Model model) {
	CIrepository.deleteById(implementationId);
	return "redirect:/implementations";
	}
	
	//Cancel enrollment by id
	@RequestMapping(value = "/cancel/enrollment/{id}", method = RequestMethod.GET)
	public String cancelEnrollment(@PathVariable("id") Long enrollmentId, Model model) {
	Erepository.deleteById(enrollmentId);
	return "redirect:/enroll";
	}
}
