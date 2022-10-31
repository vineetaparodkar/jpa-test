package com.example.hateoasdemo.model;

import com.example.hateoasdemo.controller.CustomerController;
import com.example.hateoasdemo.entity.Payment;
import org.springframework.beans.BeanUtils;
import org.springframework.hateoas.server.mvc.RepresentationModelAssemblerSupport;
import org.springframework.stereotype.Component;

/**
 * This class extends RepresentationModelAssemblerSupport which is required for Pagination.
 * It converts the Customer Entity to the Customer Model
 */
@Component
public class PaymentModelAssembler extends RepresentationModelAssemblerSupport<Payment, PaymentModel> {
    public PaymentModelAssembler() {
        super(CustomerController.class, PaymentModel.class);
    }

    @Override
    public PaymentModel toModel(Payment entity) {
        PaymentModel model = new PaymentModel();
        // Both CustomerModel and Customer have the same property names. So copy the values from the Entity to the Model
        BeanUtils.copyProperties(entity, model);
        return model;
    }
}