package com.github.arolfes.music.musiclibraryreactive.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.relational.core.mapping.Column;
import org.springframework.data.relational.core.mapping.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Table("artists")
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Artist {

  @Id
  private Integer id;
  
  @Column
  private String name;

}
