package pl.zaj.cia.filmy.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.zaj.cia.filmy.dao.entity.VideoCassete;
import pl.zaj.cia.filmy.manager.VideoCassetteManager;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/cassetts")
public class VideoCasseteApi {
    //private List<VideoCassete> videoCassetes;
    private VideoCassetteManager videoCassetes;

    @Autowired
    public VideoCasseteApi(VideoCassetteManager videoCassetes) {
        this.videoCassetes = videoCassetes;
    }

    //@GetMapping("/all")
    //public List<VideoCassete> getALL() { return videoCassetes; }

    @GetMapping("/all")
    public Iterable<VideoCassete> getAll() {
        return videoCassetes.findAll();
    }

    /*@GetMapping
    public VideoCassete getById(@RequestParam int index) {
        VideoCassete first = videoCassetes.stream().filter(element->element.getId()==index).findFirst().get();
        return first;
    }*/

    /*@GetMapping
    public VideoCassete getById(@RequestParam int index) {
        Optional<VideoCassete> first = videoCassetes
                .stream()
                .filter(element -> element.getId() == index)
                .findFirst();
        return first.get();
    }*/

    @GetMapping
    public Optional<VideoCassete> getById(@RequestParam long index) {
        return videoCassetes.findAllById(index);
    }

    /*@PostMapping
    public boolean addVideo(@RequestBody VideoCassete videoCassete) {
        return videoCassetes.add(videoCassete);
    }*/

    @PostMapping
    public VideoCassete addVideo(@RequestBody VideoCassete videoCassete) {
        return videoCassetes.save(videoCassete);
    }

    /*@PutMapping
    public boolean updateVideo(@RequestBody VideoCassete videoCassete) {
        return videoCassetes.add(videoCassete);
    }*/

    @PutMapping
    public VideoCassete updateVideo(@RequestBody VideoCassete videoCassete) {
        return videoCassetes.save(videoCassete);
    }

    /*@DeleteMapping
    public boolean deleteVideo(@RequestParam int index) {
        return videoCassetes.removeIf(element -> element.getId() == index);
    }*/

    @DeleteMapping
    public void deleteVideo(@RequestParam long index) {
        videoCassetes.delete(index);
    }
}
