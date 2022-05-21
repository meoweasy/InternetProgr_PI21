package ru.ulstu.is.sbapp.student.controller;

import org.springframework.web.bind.annotation.*;
import ru.ulstu.is.sbapp.WebConfiguration;
import ru.ulstu.is.sbapp.student.service.StudentService;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(WebConfiguration.REST_API + "/student")
public class StudentController {
    private final StudentService studentService;


    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/{id}")
    public StudentDto getStudent(@PathVariable Long id) {
        return new StudentDto(studentService.findStudent(id));
    }

    @GetMapping("/")
    public List<StudentDto> getStudents() {
        return studentService.findAllStudents().stream().map(StudentDto::new).toList();
    }

    @PostMapping
    public StudentDto createStudent(@RequestBody @Valid StudentDto studentDto) {
        return new StudentDto(studentService.addStudent(studentDto.getFirstName(), studentDto.getLastName()));
    }

    @PutMapping("/{id}")
    public StudentDto updateStudent(@PathVariable Long id,
                                    @RequestBody @Valid StudentDto studentDto) {
        return new StudentDto(studentService.updateStudent(id, studentDto.getFirstName(), studentDto.getLastName()));
    }

    @DeleteMapping("/{id}")
    public StudentDto deleteStudent(@PathVariable Long id) {
        return new StudentDto(studentService.deleteStudent(id));
    }
}
