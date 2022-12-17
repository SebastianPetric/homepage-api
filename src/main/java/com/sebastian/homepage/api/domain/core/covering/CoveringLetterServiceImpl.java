package com.sebastian.homepage.api.domain.core.covering;

import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CoveringLetterServiceImpl implements ICoveringLetterService {

    @Autowired
    ICoveringLetterRepository iCoveringLetterRepository;

    @Override
    public CoveringLetter save(CoveringLetter coveringLetter) {
        return iCoveringLetterRepository.save(coveringLetter);
    }

    @Override
    public List<CoveringLetter> findAll() {
        return iCoveringLetterRepository.findAll();
    }

    @Override
    public Optional<CoveringLetter> findById(ObjectId id) {
        return iCoveringLetterRepository.findById(id);
    }

    @Override
    public CoveringLetter editById(CoveringLetter coveringLetter, PutBodyCoveringLetter toModify) {
        if (toModify.getTitle() != null)
            coveringLetter.setTitle(toModify.getTitle());
        if (toModify.getText() != null)
            coveringLetter.setText(toModify.getText());

        return iCoveringLetterRepository.save(coveringLetter);
    }

    @Override
    public void deleteById(ObjectId id) {

    }
}
