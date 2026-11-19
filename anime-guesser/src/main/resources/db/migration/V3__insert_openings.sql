INSERT INTO opening (anime, url)
VALUES (
           (SELECT id FROM anime WHERE anime_name = 'Seven Deadly Sins'),
           'https://example.com/seven-deadly-sins-op1.mp3'
       );

INSERT INTO opening (anime, url)
VALUES (
           (SELECT id FROM anime WHERE anime_name = 'Tokyo Ghoul'),
           'https://example.com/tokyo_ghoul.mp3'
       );

INSERT INTO opening (anime, url)
VALUES (
           (SELECT id FROM anime WHERE anime_name = 'Paripi Koumei'),
           'https://example.com/paripi_koumei.mp3'
       );

INSERT INTO opening (anime, url)
VALUES (
           (SELECT id FROM anime WHERE anime_name = 'Attack on Titan'),
           'https://example.com/attck_on_titan.mp3'
       );

INSERT INTO opening (anime, url)
VALUES (
           (SELECT id FROM anime WHERE anime_name = 'Kaguya-sama Love is War'),
           'https://example.com/kaguya_sama_love_is_war.mp3'
       );