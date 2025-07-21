package co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.adapter;

import co.edu.udea.nexum.profile.coursed_program.domain.model.ProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.domain.model.aggregate.FullProgramVersion;
import co.edu.udea.nexum.profile.coursed_program.domain.spi.ProgramVersionPersistencePort;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.client.ProgramVersionFeign;
import co.edu.udea.nexum.profile.coursed_program.infrastructure.output.feign.mapper.ProgramVersionFeignResponseMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class ProgramVersionFeignAdapter implements ProgramVersionPersistencePort {
    private final ProgramVersionFeign programVersionFeign;
    private final ProgramVersionFeignResponseMapper programVersionFeignResponseMapper;

    @Override
    public ProgramVersion findById(Long id) {
        return programVersionFeignResponseMapper.toDomain(
                programVersionFeign.findById(id)
        );
    }

    @Override
    public List<FullProgramVersion> findAll() {
        return programVersionFeignResponseMapper.toFullDomains(
                programVersionFeign.findAll()
        );
    }
}
