package com.example.demo.service;

import lombok.extern.slf4j.Slf4j;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.example.demo.dto.SubredditDto;
import com.example.demo.exceptions.SpringRedditException;
import com.example.demo.mapper.SubredditMapper;
import com.example.demo.model.Subreddit;
import com.example.demo.repository.SubredditRepository;

import java.util.List;

import static java.util.stream.Collectors.toList;

@Service

@Slf4j
public class SubredditService {
	@Autowired
    private  SubredditRepository subredditRepository;
	
    private  SubredditMapper subredditMapper;

    @Transactional
    public SubredditDto save(SubredditDto subredditDto) {
        Subreddit save = subredditRepository.save(subredditMapper.mapDtoToSubreddit(subredditDto));
        subredditDto.setId(save.getId());
        return subredditDto;
    }

    @Transactional(readOnly = true)
    public List<SubredditDto> getAll() {
        return subredditRepository.findAll()
                .stream()
                .map(subredditMapper::mapSubredditToDto)
                .collect(toList());
    }

    public SubredditDto getSubreddit(Long id) {
        Subreddit subreddit = subredditRepository.findById(id)
                .orElseThrow(() -> new SpringRedditException("No subreddit found with ID - " + id));
        return subredditMapper.mapSubredditToDto(subreddit);
    }
}
