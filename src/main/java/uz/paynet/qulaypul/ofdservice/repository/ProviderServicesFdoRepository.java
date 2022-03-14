package uz.paynet.qulaypul.ofdservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.paynet.qulaypul.ofdservice.domain.ProviderServicesFdo;

import java.util.Collection;
import java.util.List;

@Repository
public interface ProviderServicesFdoRepository extends JpaRepository<ProviderServicesFdo, Long> {
    ProviderServicesFdo findByServiceId(Integer paramInteger);

    List<ProviderServicesFdo> findAll();

    List<ProviderServicesFdo> findAllByServiceIdIn(Collection<Integer> service_id);
}

