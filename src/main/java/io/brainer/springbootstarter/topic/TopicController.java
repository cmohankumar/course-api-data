package io.brainer.springbootstarter.topic;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TopicController {
	
	@Autowired
	private TopicService topicService;
	
	@RequestMapping("/topics")
	public List<Topic> getAllTopics( ) {
		return topicService.getAllTopics();
	}
	
	@RequestMapping("/topics/{Id}")
	public Topic getTopic(@PathVariable String Id) {
		return topicService.getTopic(Id);
	}

	@RequestMapping(method=RequestMethod.POST, value= "/topics")
	public void addTopic(@RequestBody Topic topic) {
		topicService.addTopic(topic);
	}
	
	@RequestMapping(method=RequestMethod.PUT, value= "/topics/{Id}")
	public void updateTopic(@RequestBody Topic topic, @PathVariable String Id) {
		topicService.updateTopic(topic, Id);
	}
	
	@RequestMapping(method=RequestMethod.DELETE, value= "/topics/{Id}")
	public void deleteTopic(@RequestBody Topic topic, @PathVariable String Id) {
		topicService.deleteTopic(topic, Id);
	}
}
