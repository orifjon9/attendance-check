package edu.mum.cs.application.controller;

import edu.mum.cs.application.model.StudentViewModel;
import edu.mum.cs.projects.attendance.domain.entity.Student;
import edu.mum.cs.projects.attendance.ooxml.SpreadsheetReaderDAO;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Created by orifjon9 on 7/5/2017.
 */
@RestController
@RequestMapping(value="/students")
public class StudentController {

    @RequestMapping(method = RequestMethod.GET)
    public List<StudentViewModel> students() {
        return SpreadsheetReaderDAO.loadStudentList().stream()
                .map(m->new StudentViewModel(m))
                .collect(Collectors.toList());
    }

    @RequestMapping(value = "/{studentId}", method = RequestMethod.GET)
    public Student student(@PathVariable String studentId) {
        return SpreadsheetReaderDAO.findStudent(studentId);
    }
}
