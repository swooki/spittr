package spittr.data;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.stereotype.Component;

import spittr.Spittle;

@Component
public class DummySpittleRepository implements SpittleRepository {

    @Override
    public List<Spittle> findSpittles(long max, int count) {
	ArrayList<Spittle> spittles = new ArrayList<Spittle>();
	for(int i=0; i<count; i++) {
	    spittles.add(new Spittle("Dummy Spittle " + i, new Date()));
	}
	return spittles;
    }

}
