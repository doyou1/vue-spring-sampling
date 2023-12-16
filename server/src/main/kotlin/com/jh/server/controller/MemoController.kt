package com.jh.server.controller

import com.jh.server.domain.Memo
import com.jh.server.domain.ResponseData
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/memo")
class MemoController {
    val list =  mutableListOf<Memo>().apply {
        repeat(2){ this.add( Memo(
                id = it,
                content = "",
                isDone = false,
        )) }
    }

    @GetMapping("")
    fun list() : List<Memo> {
        return list.toList()
    }

    @PostMapping("")
    fun new() : ResponseEntity<ResponseData> {
        val id = list.size
        val newMemo = Memo(id=id, content = "", isDone = false)
        list.add(newMemo)
        return ResponseEntity.ok(ResponseData(id, true))
    }

    @PutMapping("/{id}")
    @CrossOrigin
    fun put(@PathVariable id: Int , @RequestBody memo: Memo) : ResponseEntity<ResponseData> {
        val newList = list.map { if (it.id == id) memo else it }
        list.clear()
        list.addAll(newList)
        return ResponseEntity.ok(ResponseData(id, true))
    }
}
