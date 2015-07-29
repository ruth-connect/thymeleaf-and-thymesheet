package com.connect_group.thymeleaf_demo.tdd;

import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.exists;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.hasAttribute;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.hasClass;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.hasClasses;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.hasOnlyText;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.isSingleElementThat;
import static com.connect_group.thymeleaf.testing.hamcrest.ThymeleafMatchers.occursOnce;
import static org.hamcrest.CoreMatchers.not;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.junit.Assert.assertThat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.connect_group.thymeleaf.testing.ThymeleafTestEngine;
import com.connect_group.thymeleaf_demo.beans.music.Album;
import com.connect_group.thymeleaf_demo.beans.music.Artist;
import com.connect_group.thymeleaf_demo.config.SpringBootTestThymesheetContext;
import com.connect_group.thymesheet.css.selectors.NodeSelectorException;
import com.connect_group.thymesheet.query.HtmlElements;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = SpringBootTestThymesheetContext.class)
public class MusicTests {

	private static final String HTML_PATH = "tdd/music/music.html";

	@Autowired
	private ThymeleafTestEngine selectorEngine;

	@Before
	public void setup() {
	}
	
	@Test
	@Ignore
	public void shouldShowOneArtistTab_WhenThereIsOneArtist() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li"), occursOnce());
	}
	
	@Test
	@Ignore
	public void shouldShowNoArtistTabs_WhenThereAreNoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", new ArrayList<Artist>());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li"), not(exists()));
	}
	
	@Test
	@Ignore
	public void shouldShowTwoArtistTabs_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li"), hasSize(2));
	}
	
	@Test
	@Ignore
	public void shouldSetTheFirstTabCssClassesToTabTitleAndActive_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li:first-of-type"), isSingleElementThat(hasClasses("tab-title active")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheSecondTabCssClassToTabTitle_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li:first-of-type"), isSingleElementThat(hasClass("tab-title")));
	}
	
	@Test
	@Ignore
	public void shouldNotSetTheSecondTabCssClassToActive_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li:nth-of-type(2)"), isSingleElementThat(not(hasClass("active"))));
	}
	
	@Test
	@Ignore
	public void shouldSetTheFirstTabHrefToArtist1_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li:first-of-type a"), isSingleElementThat(hasAttribute("href", "#artist1")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheSecondTabHrefToArtist2_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li:nth-of-type(2) a"), isSingleElementThat(hasAttribute("href", "#artist2")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheTabNameToTheArtistName_WhenThereIsOneArtist() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-tabs li a"), isSingleElementThat(hasOnlyText("expected artist name")));
	}
	
	@Test
	@Ignore
	public void shouldShowOneArtist_WhenThereIsOneArtist() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist"), occursOnce());
	}
	
	@Test
	@Ignore
	public void shouldShowNoArtists_WhenThereAreNoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", new ArrayList<Artist>());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist"), not(exists()));
	}
	
	@Test
	@Ignore
	public void shouldShowTwoArtists_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist"), hasSize(2));
	}
	
	@Test
	@Ignore
	public void shouldSetTheFirstArtistDivCssClassesToArtistContentAndActive_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:first-of-type"), isSingleElementThat(hasClasses("artist content active")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheSecondArtistDivCssClassesToArtistContent_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:nth-of-type(2)"), isSingleElementThat(hasClasses("artist content")));
	}
	
	@Test
	@Ignore
	public void shouldNotSetTheSecondArtistDivCssClassToActive_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:nth-of-type(2)"), isSingleElementThat(not(hasClass("active"))));
	}
	
	@Test
	@Ignore
	public void shouldSetTheFirstArtistIdToArtist1_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:first-of-type"), isSingleElementThat(hasAttribute("id", "artist1")));
	}

	@Test
	@Ignore
	public void shouldSetTheSecondArtistIdToArtist2_WhenThereAreTwoArtists() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:nth-of-type(2)"), isSingleElementThat(hasAttribute("id", "artist2")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheArtistImageSrc_WhenThereIsOneArtist() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist-image"), isSingleElementThat(hasAttribute("src", "expected artist image")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheArtistName_WhenThereIsOneArtist() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist h2"), isSingleElementThat(hasOnlyText("expected artist name")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheArtistBio_WhenThereIsOneArtist() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist p.bio i"), isSingleElementThat(hasOnlyText("expected artist bio")));
	}
	
	@Test
	@Ignore
	public void shouldShowOneAlbum_WhenThereIsOneAlbum() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithOneAlbum());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album"), occursOnce());
	}
	
	@Test
	@Ignore
	public void shouldShowNoAlbums_WhenThereAreNoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithNoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album"), not(exists()));
	}
	
	@Test
	@Ignore
	public void shouldShowTwoAlbums_WhenThereAreTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album"), hasSize(2));
	}
	
	@Test
	@Ignore
	public void shouldSetTheFirstArtistFirstAccordionEntryHrefToArtist1Album1_WhenThereAreTwoArtistsEachWithTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsEachWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:first-of-type .album:first-of-type a"), isSingleElementThat(hasAttribute("href", "#artist1-album1")));		
	}
	
	@Test
	@Ignore
	public void shouldSetTheFirstArtistSecondAccordionEntryHrefToArtist1Album2_WhenThereAreTwoArtistsEachWithTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsEachWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:first-of-type .album:nth-of-type(2) a"), isSingleElementThat(hasAttribute("href", "#artist1-album2")));		
	}

	@Test
	@Ignore
	public void shouldSetTheSecondArtistFirstAccordionEntryHrefToArtist2Album1_WhenThereAreTwoArtistsEachWithTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsEachWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:nth-of-type(2) .album:first-of-type a"), isSingleElementThat(hasAttribute("href", "#artist2-album1")));		
	}
	
	@Test
	@Ignore
	public void shouldSetTheSecondArtistSecondAccordionEntryHrefToArtist2Album2_WhenThereAreTwoArtistsEachWithTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsEachWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:nth-of-type(2) .album:nth-of-type(2) a"), isSingleElementThat(hasAttribute("href", "#artist2-album2")));		
	}
	
	@Test
	@Ignore
	public void shouldSetTheAccordionEntryNameToTheAlbumName_WhenThereIsOneAlbum() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithOneAlbum());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album a"), isSingleElementThat(hasOnlyText("expected album name")));		
	}

	@Test
	@Ignore
	public void shouldSetTheFirstArtistFirstAlbumIdToArtist1Album1_WhenThereAreTwoArtistsEachWithTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsEachWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:first-of-type .album:first-of-type > div"), isSingleElementThat(hasAttribute("id", "artist1-album1")));		
	}
	
	@Test
	@Ignore
	public void shouldSetTheFirstArtistSecondAlbumIdToArtist1Album2_WhenThereAreTwoArtistsEachWithTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsEachWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:first-of-type .album:nth-of-type(2) > div"), isSingleElementThat(hasAttribute("id", "artist1-album2")));		
	}

	@Test
	@Ignore
	public void shouldSetTheSecondArtistFirstAlbumIdToArtist2Album1_WhenThereAreTwoArtistsEachWithTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsEachWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:nth-of-type(2) .album:first-of-type > div"), isSingleElementThat(hasAttribute("id", "artist2-album1")));		
	}
	
	@Test
	@Ignore
	public void shouldSetTheSecondArtistSecondAlbumIdToArtist2Album2_WhenThereAreTwoArtistsEachWithTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getTwoArtistsEachWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".artist:nth-of-type(2) .album:nth-of-type(2) > div"), isSingleElementThat(hasAttribute("id", "artist2-album2")));		
	}
	
	@Test
	@Ignore
	public void shouldSetTheFirstAlbumCssClassesToContentAndActive_WhenThereAreTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album:first-of-type > div"), isSingleElementThat(hasClasses("content active")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheSecondAlbumCssClassToContent_WhenThereAreTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album:nth-of-type(2) > div"), isSingleElementThat(hasClass("content")));
	}

	@Test
	@Ignore
	public void shouldNotSetTheSecondAlbumCssClassToActive_WhenThereAreTwoAlbums() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithTwoAlbums());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album:nth-of-type(2) > div"), isSingleElementThat(not(hasClass("active"))));
	}
	
	@Test
	@Ignore
	public void shouldSetTheAlbumImageSrc_WhenThereIsOneAlbum() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithOneAlbum());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album-image"), isSingleElementThat(hasAttribute("src", "expected album image")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheAlbumName_WhenThereIsOneAlbum() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithOneAlbum());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album h3"), isSingleElementThat(hasOnlyText("expected album name")));
	}
	
	@Test
	@Ignore
	public void shouldSetTheAlbumDescription_WhenThereIsOneAlbum() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithOneAlbum());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".album p i"), isSingleElementThat(hasOnlyText("expected album description")));
	}
	
	@Test
	@Ignore
	public void shouldNotShowCdAvailableImage_WhenCdIsNotAvailable() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithOneAlbum());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".cd-available"), not(exists()));
	}
	
	@Test
	@Ignore
	public void shouldShowCdAvailableImage_WhenCdIsAvailable() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Artist> artists = getOneArtistWithOneAlbum();
		artists.get(0).getAlbums().get(0).setCdAvailable(true);
		model.put("artists", artists);
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".cd-available"), occursOnce());
	}

	@Test
	@Ignore
	public void shouldNotShowVinylAvailableImage_WhenVinylIsNotAvailable() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithOneAlbum());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".vinyl-available"), not(exists()));
	}
	
	@Test
	@Ignore
	public void shouldShowVinylAvailableImage_WhenVinylIsAvailable() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Artist> artists = getOneArtistWithOneAlbum();
		artists.get(0).getAlbums().get(0).setVinylAvailable(true);
		model.put("artists", artists);
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".vinyl-available"), occursOnce());
	}

	@Test
	@Ignore
	public void shouldNotShowDownloadAvailableImage_WhenDownloadIsNotAvailable() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getOneArtistWithOneAlbum());
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".download-available"), not(exists()));
	}
	
	@Test
	@Ignore
	public void shouldShowDownloadAvailableImage_WhenDownloadIsAvailable() throws NodeSelectorException {
		Map<String, Object> model = new HashMap<String, Object>();
		List<Artist> artists = getOneArtistWithOneAlbum();
		artists.get(0).getAlbums().get(0).setDownloadAvailable(true);
		model.put("artists", artists);
		HtmlElements tags = selectorEngine.process(HTML_PATH, model);
		assertThat(tags.matching(".download-available"), occursOnce());
	}

	private List<Artist> getOneArtistWithNoAlbums() {
		Artist artist = new Artist();
		artist.setName("expected artist name");
		artist.setImage("expected artist image");
		artist.setBio("<i>expected artist bio</i>");
		return Collections.singletonList(artist);
	}
	
	private List<Artist> getTwoArtistsWithNoAlbums() {
		List<Artist> artists = new ArrayList<>();
		artists.add(new Artist());
		artists.add(new Artist());
		return artists;
	}
	
	private List<Artist> getOneArtistWithOneAlbum() {
		Artist artist = new Artist();
		Album album = new Album();
		album.setName("expected album name");
		album.setImage("expected album image");
		album.setDescription("<i>expected album description</i>");
		artist.setAlbums(Collections.singletonList(album));
		return Collections.singletonList(artist);
	}
	
	private List<Artist> getOneArtistWithTwoAlbums() {
		Artist artist = new Artist();
		List<Album> albums = new ArrayList<>();
		albums.add(new Album());
		albums.add(new Album());
		artist.setAlbums(albums);
		return Collections.singletonList(artist);
	}
	
	private List<Artist> getTwoArtistsEachWithTwoAlbums() {
		List<Artist> artists = new ArrayList<>();
		Artist artist = new Artist();
		List<Album> albums = new ArrayList<>();
		albums.add(new Album());
		albums.add(new Album());
		artist.setAlbums(albums);
		artists.add(artist);
		artists.add(artist);
		return artists;
	}
}
