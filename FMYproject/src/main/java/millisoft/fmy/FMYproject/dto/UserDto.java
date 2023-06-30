package millisoft.fmy.FMYproject.dto;

import java.time.LocalDate;

public record UserDto(
        String fullName,
        LocalDate age
)
{

}
