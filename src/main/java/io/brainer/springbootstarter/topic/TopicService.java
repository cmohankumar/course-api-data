package io.brainer.springbootstarter.topic;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {
	
	@Autowired
	private TopicRepository topicRepository;
		
	public List<Topic> getAllTopics() {

		List<Topic> topics = new ArrayList<>();
		topicRepository.findAll()
				.forEach(topics::add);
		return topics;
	}
 
	public Topic getTopic(String Id) {
		return topicRepository.findOne(Id);
	}

	public void addTopic(Topic topic) {
		topicRepository.save(topic);
	}

	public void updateTopic(Topic topic, String Id) {
		topicRepository.save(topic);
	}

	public void deleteTopic(Topic topic, String id) {
		topicRepository.delete(id);
	}
}
