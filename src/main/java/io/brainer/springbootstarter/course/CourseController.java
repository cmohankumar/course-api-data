package io.brainer.springbootstarter.course;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import io.brainer.springbootstarter.topic.Topic;

@RestController
public class CourseController {
	
	@Autowired
	private CourseService CourseService;
	
	@RequestMapping("/topics/{id}/courses")
	public List<Course> getAllTopics(@PathVariable String id) {
		return CourseService.getAllCourses(id);
	}
	
	@RequestMapping("/topics/{topicId}/courses/{id}")
	public Course getCourse(@PathVariable String id) {
		return CourseService.getCourse(id);
	}

	@RequestMapping(method=RequestMethod.POST, value= "/topics/{topicId}/courses")
	public void addCourse(@RequestBody Course course, @PathVariable String topicId) {
		course.setTopic(new Topic(topicId, "",""));
		CourseService.addCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value= "/topics/{topicId}/courses/{id}")
	public void updateCourse(@RequestBody Course course, @PathVariable String topicId, String id) {
		course.setTopic(new Topic(topicId, "",""));
		CourseService.updateCourse(course);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/topics/{topicId}/courses/{id}")
	public void deleteCourse(@PathVariable String id) {
		CourseService.deleteCourse(id);
	}
}
