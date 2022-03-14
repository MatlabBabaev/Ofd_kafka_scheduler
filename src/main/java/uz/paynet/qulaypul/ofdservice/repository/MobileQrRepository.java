package uz.paynet.qulaypul.ofdservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import uz.paynet.qulaypul.ofdservice.domain.MobileQr;

@Repository
public interface MobileQrRepository extends JpaRepository<MobileQr, Long> {
}

