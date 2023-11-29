package project.service.impl;

/**
 *
 */
/**
 * @author s727953
 *
 */

import java.util.ArrayList;
import java.util.List;

import project.repository.OwnerRepo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import project.entity.CarDTO;
import project.entity.OwnerDTO;
import project.service.OwnerService;
import project.uito.CarUITO;
import project.uito.OwnerUITO;

@Service
@Transactional
public class OwnerServiceImpl implements OwnerService {
    @Autowired
    OwnerRepo ownerRepo;

    @Override
    @Transactional(readOnly = false)
    public OwnerUITO doSaveOwner(OwnerUITO ownerUiTO) {
        OwnerDTO dto = UiToToDto(ownerUiTO);
        dto = ownerRepo.save(dto);
        BeanUtils.copyProperties(dto, ownerUiTO);

        dtoToUito(ownerUiTO, dto);
        return ownerUiTO;
    }

    private void dtoToUito(OwnerUITO ownerUiTO, OwnerDTO dto) {
        CarUITO uitTO = new CarUITO();
        BeanUtils.copyProperties(dto.getCarDTO(), uitTO);
        ownerUiTO.setCarUITO(uitTO);
    }

    private OwnerDTO UiToToDto(OwnerUITO ownerUiTO) {
        OwnerDTO dto = new OwnerDTO();
        CarDTO carDto = new CarDTO();
        BeanUtils.copyProperties(ownerUiTO, dto);
        BeanUtils.copyProperties(ownerUiTO.getCarUITO(), carDto);
        dto.setCarDTO(carDto);
        List<OwnerDTO> lst = new ArrayList<>();
        lst.add(dto);
        carDto.getOwnerdtolst().addAll(lst);
        return dto;
    }

    @Override
    public List<OwnerUITO> doFetchAllOwner() {
        List<OwnerDTO> dtoLst = ownerRepo.findAll();
        List<OwnerUITO> uiTOLst = new ArrayList<>();
        dtoLst.forEach(dto -> {
            OwnerUITO tmpUiTO = new OwnerUITO();
            System.out.println(dto.getCarDTO());
            BeanUtils.copyProperties(dto, tmpUiTO);

            dtoToUito(tmpUiTO, dto);
            uiTOLst.add(tmpUiTO);
        });
        return uiTOLst;
    }

    @Override
    public OwnerUITO doGetOwner(OwnerUITO ownerUiTO) {
        if (null != ownerUiTO.getEmailId()) {
            OwnerDTO dto = new OwnerDTO();

            BeanUtils.copyProperties(ownerUiTO, dto);
            dto = ownerRepo.getOne(dto.getOwnerId());

            BeanUtils.copyProperties(dto, ownerUiTO);
        }
        return ownerUiTO;
    }

    @Override
    @Transactional
    public void doDeleteOwner(OwnerUITO ownerUiTO) {

        ownerRepo.deleteById(ownerUiTO.getOwnerId());
    }

}
