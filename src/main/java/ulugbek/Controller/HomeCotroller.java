package ulugbek.Controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ulugbek.Entity.Student;
import ulugbek.service.CustomerService;

import java.util.List;


@Controller
public class HomeCotroller {

    @Autowired
    private CustomerService studentService;

    @GetMapping("/list")
    public String listStudent(Model theModel) {

        // get customers from the service
        List<Student> theStudent = studentService.getStudent();

        // add the customers to the model
        theModel.addAttribute("student", theStudent);

        return "list-customers";
    }

    @GetMapping("/showFormForAdd")
    public String showFormForAdd(Model theModel) {

        // create model attribute to bind form data
        Student theStudent = new Student();

        theModel.addAttribute("student", theStudent);

        return "customer-form";
    }

    @PostMapping("/saveCustomer")
    public String saveStudent(@ModelAttribute("student") Student theStudent) {

        // save the customer using our service
        studentService.saveStudent(theStudent);

        return "redirect:/customer/list";
    }

    @GetMapping("/showFormForUpdate")
    public String showFormForUpdate(@RequestParam("studentId") int theId,
                                    Model theModel) {

        // get the customer from our service
        Student theStudent = studentService.getStudent(theId);

        // set customer as a model attribute to pre-populate the form
        theModel.addAttribute("student", theStudent);

        // send over to our form
        return "customer-form";
    }

    @GetMapping("/delete")
    public String deleteSTudent(@RequestParam("studentId") int theId) {

        // delete the customer
        studentService.deleteStudent(theId);

        return "redirect:/customer/list";

    }

}
