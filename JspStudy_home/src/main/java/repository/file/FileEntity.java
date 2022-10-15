package repository.file;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Builder
@NoArgsConstructor
@AllArgsConstructor
@Data
public class FileEntity {
	private String file_code;
	private String file_name;
	private LocalDateTime create_date;
	private LocalDateTime update_date;
}
