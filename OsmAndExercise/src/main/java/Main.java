import de.westnordost.osmapi.OsmConnection;
import de.westnordost.osmapi.map.MapDataDao;
import de.westnordost.osmapi.map.data.Node;
import org.openstreetmap.osmosis.core.container.v0_6.EntityContainer;
import org.openstreetmap.osmosis.core.domain.v0_6.Tag;
import org.openstreetmap.osmosis.core.task.v0_6.Sink;
import org.openstreetmap.osmosis.xml.v0_6.XmlDownloader;

import java.util.*;

public class Main implements Sink {
	private final OsmConnection connection =
			new OsmConnection("https://api.openstreetmap.org/api/0.6/", "java");
	private final MapDataDao mapDAO = new MapDataDao(connection);

	public static void main(String[] args) {
		XmlDownloader downloader = new XmlDownloader(153.5022, 153.3492, -27.8459, -27.9165,
				"https://www.openstreetmap.org/api/0.6");
		downloader.setSink(new Main());
		downloader.run();
	}

	@Override
	public void process(EntityContainer entityContainer) {
		boolean isArea = false;
		String areaName = null;

		for (Tag tag : entityContainer.getEntity().getTags()) {
			switch (tag.getKey()) {
				case "amenity":
				case "building":
					isArea = true;
					break;
				case "name":
					areaName = tag.getValue();
			}
		}

		if (isArea) {
			System.out.println("-----------");
			System.out.println(areaName);
		}
//		System.out.println(1);
	}

	@Override
	public void initialize(Map<String, Object> map) {
//		System.out.println(2);
	}

	@Override
	public void complete() {
//		System.out.println(3);
	}

	@Override
	public void close() {
//		System.out.println(4);
	}
}