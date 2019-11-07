USE jpa_db;


    insert into post_details (is_awesome, history_of_post, topic_description) values
    (true, 'really old post', 'Magic the Gathering Comes Alive'),
    (false, 'somewhat old', 'Licks to the Chocolately Center of a Tootsie Pop');


    insert into posts (title, description) values
    ('hello out there', 'just simple cry for help when lost on lonely island'),
    ('echo', 'sound of cave walls');

#
# # seed pet_details
#     insert into pet_details (is_sterile, personality_description, weight_in_ounces) values
#     (true, 'A good dog', 45.23),
#     (false, 'A good cat', 15.23),
#     (true, 'A good fish', 5.23),
#     (false, 'A good alligator', 95.23),
#     (false, 'A good snake', 195.23);
#
# # seed pets
# insert into pets (name, dob, species, pet_details_id) values
# ('Sparky', '2010-01-01', 'Dog', 1),
# ('Sparkles', '2010-01-01', 'Cat', 2),
# ('Spark', '2010-01-01', 'Fish', 3),
# ('Parky', '2010-01-01', 'Alligator', 4),
# ('Bubbles', '2010-01-01', 'Snake', 5);
#
#
