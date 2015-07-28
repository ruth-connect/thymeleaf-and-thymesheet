package com.connect_group.thymeleaf_demo.controller.tdd;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.connect_group.thymeleaf_demo.beans.music.Album;
import com.connect_group.thymeleaf_demo.beans.music.Artist;

@Controller
public class MusicController {

	@RequestMapping({"/tdd/music.html"})
    public ModelAndView music() {
		Map<String, Object> model = new HashMap<String, Object>();
		model.put("artists", getArtists());
        return new ModelAndView("tdd/music/music", model);
    }
	
	private List<Artist> getArtists() {
		List<Artist> artists = new ArrayList<>();
		artists.add(getEnya());
		artists.add(getJeanMichelJarre());
		artists.add(getMikeOldfield());
		artists.add(getVangelis());
		return artists;
	}
	
	private Artist getEnya() {
		Artist enya = new Artist();
		enya.setName("Enya");
		enya.setBio("Born Eithne Ni Bhraonain, this classically-trained pianist was kid sister in the musical family that became Clannad, joining the Irish band in 1979 but dropping out amicably three years later to pursue her own muse.");
		enya.setImage("/music-images/enya/enya.jpg");
		List<Album> albums = new ArrayList<>();
		
		Album watermark = new Album();
		watermark.setName("Watermark");
		watermark.setDescription("Enya's 1988 recording, <i>Watermark</i>, achieved landmark success with her groundbreaking use of multi-tracking technology to fuse new age and Celtic themes and instrumentation. The meticulous production defines her sound and achieves continuity even while weaving together tender ballads, piano pieces, massively layered vocal harmonies and symphonic synthesizer movements. Although Enya's pristine voice isn't especially strong, her lead vocals possess a vulnerability that reflects the lyrics' sense of personal searching. From the ubiquitous, frothy single \"Orinoco Flow\" to the hard, bold edge of \"Cursum Perficio\", Enya's style remains fresh and engaging.");
		watermark.setImage("/music-images/enya/watermark.jpg");
		watermark.setCdAvailable(true);
		watermark.setVinylAvailable(true);
		watermark.setDownloadAvailable(true);
		albums.add(watermark);
		
		Album shepherdMoons = new Album();
		shepherdMoons.setName("Shepherd Moons");
		shepherdMoons.setDescription("The success of her first international hit, <i>Watermark</i>, confirmed Enya as less a singer or songwriter than a sonic architect: working with producer Nicky Ryan and his wife, lyricist Roma Ryan, the classically trained pianist built vaulting cathedrals of sound, framed by luminous piano, shimmering synthesizer orchestrations, and, above all, the seemingly infinite layers of vocal harmonies she applied to every song. The deeply romantic Celtic pop on its 1991 successor, Shepherd Moons, sustains the same spectrum of hushed reverie and surging, rhapsodic releases, as well as its mix of ballads, floating midtempo pieces, and forays into Celtic and Latin-- and it's every bit as seductive. The terminally hip will sneer, but it's no accident that \"Caribbean Blue\", the best known song here, managed to sneak onto modern rock, top 40, and adult-oriented radio playlists.");
		shepherdMoons.setImage("/music-images/enya/shepherd-moons.jpg");
		shepherdMoons.setCdAvailable(true);
		shepherdMoons.setDownloadAvailable(true);
		albums.add(shepherdMoons);
		
		Album theCelts = new Album();
		theCelts.setName("The Celts");
		theCelts.setDescription("This music, produced in the mid-'80s as the soundtrack to a BBC series, was released as her debut in 1987 and promptly ignored--yet its mix of atmospheric soundscapes and Enya's lush, layered vocals, sung in both English and Gaelic, is the template for her subsequent global hits, beginning with Watermark the following year.");
		theCelts.setImage("/music-images/enya/the-celts.jpg");
		theCelts.setCdAvailable(true);
		theCelts.setVinylAvailable(true);
		theCelts.setDownloadAvailable(true);
		albums.add(theCelts);
		
		Album theMemoryOfTrees = new Album();
		theMemoryOfTrees.setName("The Memory of Trees");
		theMemoryOfTrees.setDescription("<i>The Memory of Trees</i> is a 1995 studio album by Irish musician Enya. The album sold more than 9 million copies and, in 1997, won the Grammy Award for Best New Age Album.");
		theMemoryOfTrees.setImage("/music-images/enya/the-memory-of-trees.jpg");
		theMemoryOfTrees.setCdAvailable(true);
		theMemoryOfTrees.setDownloadAvailable(true);
		albums.add(theMemoryOfTrees);
		
		enya.setAlbums(albums);
		return enya;
	}
	
	private Artist getJeanMichelJarre() {
		Artist jeanMichelJarre = new Artist();
		jeanMichelJarre.setName("Jean Michel Jarre");
		jeanMichelJarre.setBio("<i>Jean Michel Jarre</i> (born Jean-Michel André Jarre; 24 August 1948) is a French composer, performer, and music producer. He is a pioneer in the electronic, ambient, and new-age genres, and known as an organiser of outdoor spectacles of his music featuring lights, laser displays, and fireworks.");
		jeanMichelJarre.setImage("/music-images/jean-michel-jarre/jean-michel-jarre.jpg");
		List<Album> albums = new ArrayList<>();
		
		Album oxygene = new Album();
		oxygene.setName("Oxygene");
		oxygene.setDescription("With Jarre’s spectacular major label debut released in 1976 and awarded with the Grand Prix du Disque, electronic music ultimately left the confines of elitism and entered the international charts.");
		oxygene.setImage("/music-images/jean-michel-jarre/oxygene.jpg");
		oxygene.setCdAvailable(true);
		oxygene.setVinylAvailable(true);
		oxygene.setDownloadAvailable(true);
		albums.add(oxygene);
		
		Album equinoxe = new Album();
		equinoxe.setName("Equinoxe");
		equinoxe.setDescription("The follow-up album “Equinoxe” (1978) describes a person’s daily routine from morning to night using dynamic rhythms and brilliant melodies.");
		equinoxe.setImage("/music-images/jean-michel-jarre/equinoxe.jpg");
		equinoxe.setCdAvailable(true);
		equinoxe.setVinylAvailable(true);
		albums.add(equinoxe);
		
		Album magneticFields = new Album();
		magneticFields.setName("Magnetic Fields");
		magneticFields.setDescription("Inspired by Andy Warhol’s work, Jarre recorded the album “Magnetic Fields” in 1981. He was invited to China soon after to introduce the opus with five concerts in Peking and Shanghai.");
		magneticFields.setImage("/music-images/jean-michel-jarre/magnetic-fields.jpg");
		magneticFields.setCdAvailable(true);
		albums.add(magneticFields);
		
		Album rendezvous = new Album();
		rendezvous.setName("Rendezvous");
		rendezvous.setDescription("Just after his live performance in Houston to celebrate NASA's anniversary, Jean-Michel Jarre released <i>Rendez-Vous</i>, an appropriately cosmic-sounding album of glittering synth-pop. It consists of the same music heard at the Houston concert and shows Jarre moving closer to conventional rock territory, though still with his distinct blueprint. The final track, \"Last Rendez-Vous: Ron's Piece,\" was composed by Jarre for astronaut Ron McNair and was intended to be the first musical piece played and recorded in space. McNair's historic duty was cut short, however, by the Challenger shuttle disaster of January 1986.");
		rendezvous.setImage("/music-images/jean-michel-jarre/rendezvous.jpg");
		rendezvous.setCdAvailable(true);
		rendezvous.setVinylAvailable(true);
		rendezvous.setDownloadAvailable(true);
		albums.add(rendezvous);
		
		Album chronologie = new Album();
		chronologie.setName("Chronologie");
		chronologie.setDescription("<i>Chronologie</i> (English: \"chronology\" – some later reissues use the English spelling) is an album by French electronic musician Jean Michel Jarre, and was released on Disques Dreyfus (with license to Polydor) in 1993. It is his eighth overall studio album. It is inspired by Stephen Hawking's book A Brief History of Time. \"Chronologie Part 4\" and \"Chronologie Part 5\" started out as a composition for the Swiss watch company Swatch. The sound of Chronologie was based on a new wave of electronic dance music that had been developing since the late 1980s. Like Jarre's previous album Waiting for Cousteau, Chronologie charted at Number 11 in the UK charts.");
		chronologie.setImage("/music-images/jean-michel-jarre/chronologie.jpg");
		chronologie.setCdAvailable(true);
		chronologie.setDownloadAvailable(true);
		albums.add(chronologie);
		
		jeanMichelJarre.setAlbums(albums);
		return jeanMichelJarre;
	}
	
	private Artist getMikeOldfield() {
		Artist mikeOldfield = new Artist();
		mikeOldfield.setName("Mike Oldfield");
		mikeOldfield.setBio("Michael Gordon \"Mike\" Oldfield (born 15 May 1953) is an English musician and composer. His work blends progressive rock with world, folk, classical, electronic, ambient, and new-age music. He is best known for his 1973 album Tubular Bells – which launched Virgin Records and became a hit after its opening was used as the theme for the film The Exorcist – and for his 1983 hit single \"Moonlight Shadow\". He is also known for his rendition of the Christmas piece \"In Dulci Jubilo\".");
		mikeOldfield.setImage("/music-images/mike-oldfield/mike-oldfield.jpg");
		List<Album> albums = new ArrayList<>();
		
		Album tubularBells = new Album();
		tubularBells.setName("Tubular Bells");
		tubularBells.setDescription("<i>Tubular Bells</i> is the debut record album of English musician Mike Oldfield, recorded when he was 19 and released in 1973.");
		tubularBells.setImage("/music-images/mike-oldfield/tubular-bells.jpg");
		tubularBells.setCdAvailable(true);
		tubularBells.setVinylAvailable(true);
		tubularBells.setDownloadAvailable(true);
		albums.add(tubularBells);
		
		Album tubularBellsII = new Album();
		tubularBellsII.setName("Tubular Bells II");
		tubularBellsII.setDescription("Little wonder that Mike Oldfield should choose, years later, to revisit his most famous work - though inevitably, this time the stakes were much higher. Good thing, then, that he took so few risks. Like its predecessor, the album unveils a series of musical tableaux, though this time without the slightest pretence of actual thematic development: it's less a single, unified piece, than a medley of pretty folk-rock instrumentals. The mood sits somewhere between foggy Celtic mysticism and pastoral elegy, occasionally pausing for a moment of unexpected light relief (the bizarre whimsy of \"Altered State\"). Unlike the original, however, it sustains its pleasures more or less evenly across the entire composition.");
		tubularBellsII.setImage("/music-images/mike-oldfield/tubular-bells-ii.jpg");
		tubularBellsII.setCdAvailable(true);
		tubularBellsII.setDownloadAvailable(true);
		albums.add(tubularBellsII);
		
		Album tubularBellsIII = new Album();
		tubularBellsIII.setName("Tubular Bells III");
		tubularBellsIII.setDescription("Tubular Bells III is the 18th album by Mike Oldfield, released in 1998 by Warner Bros. Records. A sequel to Oldfield's 1973 Tubular Bells and his 1992 Tubular Bells II albums, it was released on the 25th anniversary of the first Tubular Bells album. Oldfield created the album while living in Ibiza, and has said the inspiration for some of its electronic elements came from the styles of music played at the island's bars and clubs.");
		tubularBellsIII.setImage("/music-images/mike-oldfield/tubular-bells-iii.jpg");
		tubularBellsIII.setDownloadAvailable(true);
		albums.add(tubularBellsIII);
		
		Album theSongsOfDistantEarth = new Album();
		theSongsOfDistantEarth.setName("The Songs of Distant Earth");
		theSongsOfDistantEarth.setDescription("<i>The Songs of Distant Earth</i> is the 16th album by Mike Oldfield, released in 1994 by Warner Music. It is based on Arthur C. Clarke's science fiction novel The Songs of Distant Earth.");
		theSongsOfDistantEarth.setImage("/music-images/mike-oldfield/the-songs-of-distant-earth.jpg");
		theSongsOfDistantEarth.setCdAvailable(true);
		theSongsOfDistantEarth.setDownloadAvailable(true);
		albums.add(theSongsOfDistantEarth);
		
		Album tresLunas = new Album();
		tresLunas.setName("Tr3s Lunas");
		tresLunas.setDescription("Tr3s Lunas is a record album written and mostly performed by Mike Oldfield. It was released in 2002 with a bonus CD containing a demo program for a PC game, Tres Lunas. When translated from the Spanish language to English, the album name Tres Lunas is Three Moons. This is reflected in the typeface on the album cover, with the letter 'e' being replaced with a numeric '3'.");
		tresLunas.setImage("/music-images/mike-oldfield/tres-lunas.jpg");
		tresLunas.setCdAvailable(true);
		albums.add(tresLunas);
		
		mikeOldfield.setAlbums(albums);
		return mikeOldfield;
	}
	
	private Artist getVangelis() {
		Artist vangelis = new Artist();
		vangelis.setName("Vangelis");
		vangelis.setBio("Vangelis is a Greek composer of electronic, progressive, ambient, jazz, pop rock, and orchestral music. He is best known for his Academy Award–winning score for the film Chariots of Fire, composing scores for the films Antarctica, Blade Runner, Missing, 1492: Conquest of Paradise, and Alexander, and the use of his music in the PBS documentary Cosmos: A Personal Voyage by Carl Sagan.");
		vangelis.setImage("/music-images/vangelis/vangelis.jpg");
		List<Album> albums = new ArrayList<>();
		
		Album heavenAndHell = new Album();
		heavenAndHell.setName("Heaven and Hell");
		heavenAndHell.setDescription("<i>Heaven and Hell</i>, released in 1975, is the fifth solo album by Greek electronic composer Vangelis. It got worldwide recognition through the use of \"Movement 3\" as the theme for the television documentary series Cosmos: A Personal Voyage. Heaven and Hell was the first album Vangelis composed and recorded in his new Nemo Studios in London, the studio he used between 1975 and 1987.");
		heavenAndHell.setImage("/music-images/vangelis/heaven-and-hell.jpg");
		heavenAndHell.setVinylAvailable(true);
		albums.add(heavenAndHell);
		
		Album albedo = new Album();
		albedo.setName("Albedo 0.39");
		albedo.setDescription("<i>Albedo 0.39</i> is an album by the artist Vangelis, released in 1976. It is a concept album around space and space physics. Albedo 0.39 was the second album produced by Vangelis in Nemo Studios, London, which was his creative base until the late 1980s. It contrasts with his previous album, <i>Heaven and Hell</i>, which was classically inspired and choral, while Albedo 0.39 has blues and jazz overtones.");
		albedo.setImage("/music-images/vangelis/albedo-0.39.jpg");
		albedo.setCdAvailable(true);
		albedo.setVinylAvailable(true);
		albums.add(albedo);
		
		Album spiral = new Album();
		spiral.setName("Spiral");
		spiral.setDescription("Produced at a time when Greek keyboard wizard Vangelis was at the height of his success during the late 1970s, SPIRAL leaves behind the overtly classical pomp of 'Heaven and Hell', whilst also avoiding the obscure sonic experimentation of later albums. The result is not only one of Vangelis' most accessible recordings, it remains essential listening for fans of electronic music in general. Vangelis is one of the pioneers of instrumental rock, and the title track of SPIRAL highlights the keyboard sequencing technology which was then just being developed.");
		spiral.setImage("/music-images/vangelis/spiral.jpg");
		spiral.setVinylAvailable(true);
		spiral.setDownloadAvailable(true);
		albums.add(spiral);
		
		Album operaSauvage = new Album();
		operaSauvage.setName("Opera Sauvage");
		operaSauvage.setDescription("<i>Opéra sauvage</i> is a 1979 album by Greek composer and artist Vangelis, of the score for the nature documentary by the same title by French filmmaker Frédéric Rossif. The album sleeve design is by Vangelis himself. Vangelis produced this album during his electro-acoustic period, which was one of the most productive in his musical career. Opéra Sauvage is more akin to his classic sound than his earlier nature scores for the same director, such as L'Apocalypse des animaux and La Fête sauvage. A later collaboration with Rossif in the style of Opéra sauvage was Sauvage et Beau.");
		operaSauvage.setImage("/music-images/vangelis/opera-sauvage.jpg");
		operaSauvage.setCdAvailable(true);
		operaSauvage.setVinylAvailable(true);
		albums.add(operaSauvage);
		
		Album chariotsOfFire = new Album();
		chariotsOfFire.setName("Chariots of Fire");
		chariotsOfFire.setDescription("<i>Chariots of Fire</i> is a 1981 musical score by Greek electronic composer Vangelis (credited as Vangelis Papathanassiou) for the British film Chariots of Fire, which won four Academy Awards including Best Picture and Original Music Score.");
		chariotsOfFire.setImage("/music-images/vangelis/chariots-of-fire.jpg");
		chariotsOfFire.setCdAvailable(true);
		chariotsOfFire.setVinylAvailable(true);
		chariotsOfFire.setDownloadAvailable(true);
		albums.add(chariotsOfFire);
		
		Album bladeRunner = new Album();
		bladeRunner.setName("Blade Runner");
		bladeRunner.setDescription("The <i>Blade Runner</i> soundtrack was composed by Vangelis for Ridley Scott's 1982 film Blade Runner. It is mostly a dark, melodic combination of classical composition and synthesizers which mirrors the futuristic film noir envisioned by Scott.");
		bladeRunner.setImage("/music-images/vangelis/blade-runner.jpg");
		bladeRunner.setCdAvailable(true);
		bladeRunner.setDownloadAvailable(true);
		albums.add(bladeRunner);
		
		Album conquestOfParadise = new Album();
		conquestOfParadise.setName("1492 - Conquest of Paradise");
		conquestOfParadise.setDescription("<i>1492: Conquest of Paradise</i> is a 1992 music score by Greek electronic composer and artist Vangelis. The film, a recount of the voyage to America in 1492 by Christopher Columbus, was directed by Ridley Scott, for whom Vangelis had previously composed the music score for Blade Runner, in 1982. The album and the single \"Conquest of Paradise\" enjoyed a revival in 1995 for various reasons and broke many sales records.");
		conquestOfParadise.setImage("/music-images/vangelis/1492-conquest-of-paradise.jpg");
		conquestOfParadise.setCdAvailable(true);
		conquestOfParadise.setDownloadAvailable(true);
		albums.add(conquestOfParadise);
		
		Album voices = new Album();
		voices.setName("Voices");
		voices.setDescription("<i>Voices</i> is a 1995 album by Greek electronic composer and artist Vangelis. Its music was used in the soundtrack for the 1998 documentary Deep Sea, Deep Secrets co-produced by The Learning Channel and Discovery Channel, together with music from Vangelis next album, Oceanic. The track \"Ask the Mountains\" was also used as the music for the TV commercial for the Hotpoint/Ariston Aqualtis washing machine.");
		voices.setImage("/music-images/vangelis/voices.jpg");
		voices.setCdAvailable(true);
		albums.add(voices);
		
		Album oceanic = new Album();
		oceanic.setName("Oceanic");
		oceanic.setDescription("<i>Oceanic</i> is a 1996 album by Greek electronic composer and artist Vangelis. It was released in Europe on October 25, 1996, and in the U.S. on January 1997. A single featuring track \"Song of the Seas\" was released simultaneously.");
		oceanic.setImage("/music-images/vangelis/oceanic.jpg");
		oceanic.setCdAvailable(true);
		oceanic.setDownloadAvailable(true);
		albums.add(oceanic);
		
		vangelis.setAlbums(albums);
		return vangelis;
	}
}
