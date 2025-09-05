package org.example.service;

import com.baomidou.mybatisplus.extension.service.IService;
import org.example.entity.Appointment;

public interface AppointmentService extends IService<Appointment> {
    Appointment getOne(Appointment appointment);
}
