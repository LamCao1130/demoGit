package t3h.edu.vn.ss.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import t3h.edu.vn.ss.entity.ColorEntity;
import t3h.edu.vn.ss.repository.ColorRepository;

import java.util.ArrayList;
import java.util.List;

@Service
public class ColorService {

    @Autowired
    private ColorRepository colorRepository;

    public List<ColorEntity> findAll() {
        return colorRepository.findAll();
    }
}
