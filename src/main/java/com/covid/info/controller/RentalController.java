package com.covid.info.controller;

import com.covid.info.domain.Car;
import com.covid.info.domain.Person;
import com.covid.info.domain.Rental;
import com.covid.info.service.RentalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.sql.SQLException;

@Controller
public class RentalController {
   @Autowired
   RentalService rentalService;
   @Autowired
    public RentalController(RentalService rentalService) {
        this.rentalService = rentalService;
    }

    @GetMapping("/register")
    public ModelAndView getRegisterPage(){
       return new ModelAndView("addUser", "person", new Person());
    }
    @PostMapping(value="/register")
    public String handleRegisterForm(@RequestParam("first_name") String first_name,
                                     @RequestParam("last_name") String last_name,
                                     @RequestParam("amount") String amount,
                                     @RequestParam("model") String model) throws SQLException {
        Rental r = new Rental();
        if(amount!=""){
            r.setAmount(Integer.parseInt(amount));
        }
        rentalService.addRental(r);
        Person person = new Person();
        if(first_name!=""){
            person.setFirst_name(first_name);
        }
        if(last_name!=""){
            person.setLast_name(last_name);
        }
        person.setRental(r);
        rentalService.addPerson(person);
        Car car = new Car();
        if(model!=""){
            car.setModel(model);
        }
        car.setRental(r);
        rentalService.addCar(car);
        return "redirect:/";
    }
    @GetMapping("/delete")
    public ModelAndView getDelete(){
       return new ModelAndView("delete", "person", new Person());
    }
    @PostMapping(value="/delete")
    public String handleDelete(@ModelAttribute("person") Person person) throws SQLException {
        Integer id = null;
        Person temp_person = rentalService.getPersonByName(person.getFirst_name(), person.getLast_name());
        if (temp_person!=null) {
            rentalService.deletePersonById(temp_person.getId());
        }
        return "redirect:/";
    }

    @RequestMapping("/persons")
    public ModelAndView getUsersPage(){
       ModelAndView modelAndView = new ModelAndView("persons");
       modelAndView.addObject("persons",rentalService.getAllPersons());
       modelAndView.addObject("rentals",rentalService.getAllRentals());
       modelAndView.addObject("cars",rentalService.getAllCars());
       return modelAndView;
    }

    @RequestMapping(value="/update", method= RequestMethod.GET)
    public ModelAndView updateStatus(@RequestParam("rental_id") int rental_id){
        ModelAndView modelAndView = new ModelAndView("update");
        Rental rental = rentalService.getRental(rental_id);
        Person person = rentalService.getPersonByRentalId(rental_id);
        Car car = rentalService.getCarByRentalId(rental_id);
        modelAndView.addObject("person",person);
        modelAndView.addObject("rental",rental);
        modelAndView.addObject("car",car);
        return modelAndView;
   }
    @RequestMapping(value="/update", method= RequestMethod.POST)
    public String updateStatusForm(@RequestParam("rental_id") int rental_id,
                                   @RequestParam("first_name") String first_name,
                                   @RequestParam("last_name") String last_name,
                                   @RequestParam("amount") String amount,
                                   @RequestParam("model") String model){
        Person person = rentalService.getPersonByRentalId(rental_id);
        Rental rental = rentalService.getRental(rental_id);
        Car car = rentalService.getCarByRentalId(rental_id);
        person.setFirst_name(first_name);
        person.setLast_name(last_name);
        rental.setAmount(Integer.parseInt(amount));
        car.setModel(model);
        rentalService.flush();
        return "redirect:/persons";
    }

    @RequestMapping(value = "/deleteRecord/{id}", method = RequestMethod.POST)
    public String handleItemDelete(@PathVariable("id") int rental_id) {
        Person person = rentalService.getPersonByRentalId(rental_id);
        rentalService.deletePersonById(person.getId());
        Car car = rentalService.getCarByRentalId(rental_id);
        rentalService.deleteCarById(car.getId());
        rentalService.deleteRentalById(rental_id);
        return "redirect:/persons";

    }
}
