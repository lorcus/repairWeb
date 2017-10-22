package com.codingschool.repairWeb.Controllers.AdminControllers.VehiclesTasks;

import com.codingschool.repairWeb.Domain.User;
import com.codingschool.repairWeb.Domain.Vehicle;
import com.codingschool.repairWeb.Model.AddVehicleForm;
import com.codingschool.repairWeb.Services.VehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class AddVehicleController {

    private static final String ADD_FORM = "addForm";

    @Autowired
    private VehicleService vehicleService;

    @RequestMapping(value = "/admin/vehicles/add", method = RequestMethod.GET)
    public String getAddView(Model model) {
        model.addAttribute(ADD_FORM, new AddVehicleForm());
        return "vehicles/add";
    }

    @RequestMapping(value = "/admin/vehicle/add", method = RequestMethod.POST)
    public String doAdd(@ModelAttribute(ADD_FORM) AddVehicleForm addVehicleForm,
                        RedirectAttributes redirectAttributes) {

        //must get user we want to add the car
        //we will redirect here from the owners page?
        User userToAdd = null;
        Vehicle veh = new Vehicle(addVehicleForm.getPlate(), addVehicleForm.getBrand(), addVehicleForm.getColor(), userToAdd);

        vehicleService.save(veh);

        return "redirect:/admin/vehicles";
    }

}
