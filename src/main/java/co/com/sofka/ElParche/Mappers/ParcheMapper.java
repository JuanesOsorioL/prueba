
package co.com.sofka.ElParche.Mappers;

import co.com.sofka.ElParche.Collections.Parche;
import co.com.sofka.ElParche.DTO.ParcheDTO;
import org.springframework.stereotype.Component;

import java.util.function.Function;

@Component
public class ParcheMapper {

    public Function<Parche, ParcheDTO> mapToDTO(){
        return parche -> new ParcheDTO(parche.getId(),
                parche.getNombreParche());
    }

    public Function<ParcheDTO, Parche> mapToCollection(){
        return parcheDTO -> {
            Parche parche = new Parche();
            parche.setId(parcheDTO.getId());
            parche.setNombreParche(parcheDTO.getNombreParche());
            return parche;
        };
    }

}

