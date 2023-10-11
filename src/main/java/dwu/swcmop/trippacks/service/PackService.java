package dwu.swcmop.trippacks.service;

import dwu.swcmop.trippacks.entity.Bag;
import dwu.swcmop.trippacks.entity.Pack;
import dwu.swcmop.trippacks.entity.User;
import dwu.swcmop.trippacks.exception.ResourceNotFoundException;
import dwu.swcmop.trippacks.repository.PackRepository;
import lombok.AllArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Optional;
import java.util.OptionalInt;

@Service
@AllArgsConstructor
public class PackService {
    private final PackRepository packRepository;

    //짐 추가
//    @Transactional
//    public Pack addPack(Long bagId, String packName, Boolean isRequired){
//        Bag bag = bagRepository.findById(bagId);
//
//        Pack pack = Pack.builder()
//                .bag(bag)
//                .packName(packName)
//                .isRequired(isRequired)
//                .build();
//        return packRepository.save(pack);
//    }


    //짐 조회
    @Transactional
    public Optional<Pack> findPack(Long id){
        return packRepository.findById(id);
    }

//    @Transactional
//    public List<Pack> findAllPack(Long bagId){
//        Bag bag = bagRepository.findById(bagId);
//        return packRepository.findPackByBag(bag);
//    }

    //짐 수정
    @Transactional
    public Pack update(Long id, Pack newPack){
        Pack pack = packRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Pack", "id", id));
        pack.setPackName(newPack.getPackName());
        return packRepository.save(pack);
    }

    //짐 삭제
    @Transactional
    public void removePack(Long id){
        Pack pack = packRepository.findById(id)
                .orElseThrow(()-> new ResourceNotFoundException("Pack", "id", id));
        packRepository.delete(pack);
    }

}
