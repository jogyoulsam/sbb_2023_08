package com.sbs.sbb.question;


import com.sbs.sbb.DataNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
public class QuestionService {

    private final QuestionRepository questionRepository; // -> 이걸 삭제해버려서 실행이 안됐음

    public List<Question> getList() {
        return this.questionRepository.findAll(); // -> 이것도 또한 삭제를 같이 해버려서 실행이 안됐음
    }

    public Question getQuestion(Integer id) {
        Optional<Question> question = this.questionRepository.findById(id);
        if (question.isPresent()) {
            return question.get();
        } else {
            throw new DataNotFoundException("question not found");
        }
    }
}
