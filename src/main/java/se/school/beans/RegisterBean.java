package se.school.beans;

import se.school.ejb.EjbRegisterBean;
import se.school.jpa.SemesterTable;

import javax.inject.Inject;
import javax.inject.Named;

/**
 * @author Benjamin Olsson
 */
@Named
public class RegisterBean {
    @Inject
    EjbRegisterBean registerService;

    RegisterBean registerBean = new RegisterBean();

    void setSemester(SemesterTable semester){
        registerBean.setSemester(semester);
    }
}
