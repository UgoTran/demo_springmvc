package com.t3h.demo.one_to_many;

import org.springframework.data.jpa.repository.JpaRepository;

public interface ComRepo extends JpaRepository<Comments, Long> {
}
