package com.example.project;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import com.example.project.adapters.StoriesAdapter;
import com.example.project.models.Scene;
import com.example.project.models.Story;

import java.util.ArrayList;
import java.util.List;

public class StoriesActivity extends AppCompatActivity {

    private RecyclerView recyclerViewStories;
    private List<Story> storiesList = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stories);

        // initialiser recyclerview
        recyclerViewStories = findViewById(R.id.recycler_view_stories);
        recyclerViewStories.setLayoutManager(new LinearLayoutManager(this));

        //initialiser la liste des histoires
        setData();

        // creer adapter pour recyclerview
        StoriesAdapter storiesAdapter = new StoriesAdapter(storiesList, new StoriesAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(int position) {
                // click sur une histoire
                Intent intent = new Intent(StoriesActivity.this, StoriesDetailsActivity.class);
                intent.putExtra("story", storiesList.get(position));
                startActivity(intent);
            }
        });
        recyclerViewStories.setAdapter(storiesAdapter);
    }

    public void setData() {
        storiesList.add(new Story(R.drawable.aliba, createScenesForStory1(), "Ali baba and the forty thieves", "Ali Baba learns the special words to open a secret lair filled with the loot of the forty thieves, but when he tells his brother, Qasim, greed takes over and Qasim is found dead, leaving Ali Baba to wonder if he had been better off not knowing the words at all."));
        storiesList.add(new Story(R.drawable.liredhood, createScenesForStory2(), "Little red riding hood", "The main character of the story and its namesake, Little Red Riding Hood is described in various versions as a sweet, young girl who was well loved. She is outfitted in a red velvet cape, made for her by her grandmother, and she loves it so much that she refused to take it off."));
        storiesList.add(new Story(R.drawable.snowhite, createScenesForStory3(), "Snow white", "Snow White is the fairest in the land. When the wicked queen wants that title for herself, Snow White flees into the forest where she meets the Seven Dwarfs. But the queen is determined to be the fairest in the land. Will Snow White ever escape her evil clutches and live happily ever after?"));
        storiesList.add(new Story(R.drawable.junglebook, createScenesForStory4(), "The Jungle Book", "Venture into the Indian jungle with Mowgli, a young boy raised by wolves, as he encounters various animal friends and foes, including the wise panther Bagheera and the cunning tiger Shere Khan."));
        storiesList.add(new Story(R.drawable.alice, createScenesForStory5(), "Alice's Adventures in Wonderland", "Follow Alice as she falls down a rabbit hole into a whimsical and nonsensical world filled with peculiar characters."));
        storiesList.add(new Story(R.drawable.peterpan, createScenesForStory6(), "Peter Pan", "Embark on a magical journey to Neverland with Peter Pan, a boy who never grows up, and his fairy companion, Tinker Bell, as they have adventures with the Darling children and battle the infamous Captain Hook."));
    }

    private List<Scene> createScenesForStory1() {
        List<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene(R.drawable.scenealibaba, "Ali Baba, a poor woodcutter, discovered the secret cave of the infamous Forty Thieves. He overheard their secret password, \"Open Sesame,\" and saw the thieves return with their loot of gold and treasure."));
        scenes.add(new Scene( R.drawable.scenealibaba, "Ali Baba took some treasure from the cave and shared it with his family, but his greedy brother, Kasim, demanded to know where Ali Baba had gotten such wealth. Ali Baba confided in him about the thieves' secret cave, but Kasim did not remember the password and was caught by the thieves. The thieves killed Kasim and left his body in the cave."));
        scenes.add(new Scene(R.drawable.scenealibaba, "To avenge Kasim's death, Ali Baba's servant girl, Morgiana, came up with a plan. She disguised herself as a dancer and went to the thieves' den, where she learned the password and marked each thief's house with a sign."));
        scenes.add(new Scene(R.drawable.scenealibaba, "When the thieves realized what Morgiana had done, they planned to seek revenge on Ali Baba. They disguised themselves as oil merchants and visited Ali Baba's house, but Morgiana recognized them and outwitted them by pouring boiling oil in their containers."));
        scenes.add(new Scene(R.drawable.scenealibaba, "The thieves returned to their hideout, where their leader, the chief robber, discovered the betrayal of one of their own. He ordered the traitor to be killed and then led the rest of the thieves to Ali Baba's house, where a fight broke out. The forty thieves were eventually killed by Ali Baba and his friends, and their loot was given to the poor."));
        scenes.add(new Scene(R.drawable.scenealibaba, "Ali Baba was hailed as a hero, and his wealth and status grew. He lived a happy life with his family and Morgiana, who had become a trusted friend and advisor."));
        return scenes;
    }

    private List<Scene> createScenesForStory2() {
        List<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene(R.drawable.hoodscene, "One day, Little Red Riding Hood's mother asked her to take a basket of goodies to her grandmother who lived on the other side of the forest. Little Red Riding Hood put on her red hood and set out on her journey."));
        scenes.add(new Scene(R.drawable.hoodscene, "As Little Red Riding Hood was walking through the forest, a wolf appeared and asked her where she was going. Little Red Riding Hood told the wolf that she was going to her grandmother's house."));
        scenes.add(new Scene(R.drawable.hoodscene, "The wolf quickly ran to the grandmother's house, knocked on the door, and pretended to be Little Red Riding Hood. The grandmother let the wolf in, thinking it was her granddaughter."));
        scenes.add(new Scene(R.drawable.hoodscene, "As soon as the wolf entered the house, he ate the grandmother in one gulp and put on her clothes and cap. He then waited for Little Red Riding Hood to arrive."));
        scenes.add(new Scene(R.drawable.hoodscene, "When Little Red Riding Hood arrived, she noticed that her grandmother looked different. She asked her grandmother why her eyes were so big, and the wolf replied that it was so he could see her better. Little Red Riding Hood asked why her ears were so big, and the wolf replied that it was so he could hear her better. Little Red Riding Hood then asked why her teeth were so big, and the wolf replied that it was so he could eat her better."));
        scenes.add(new Scene(R.drawable.hoodscene, "Just as the wolf was about to eat Little Red Riding Hood, a hunter came by and heard the commotion. The hunter rushed into the house and saw the wolf. The hunter quickly shot and killed the wolf, saving Little Red Riding Hood and her grandmother."));
        scenes.add(new Scene(R.drawable.hoodscene, "Little Red Riding Hood and her grandmother were grateful to the hunter for saving them. Little Red Riding Hood realized that she should have listened to her mother's warning to not talk to strangers in the forest. She learned her lesson and promised to be more careful in the future."));
        return scenes;
    }

    private List<Scene> createScenesForStory3() {
        List<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene(R.drawable.scenesnowhite, "The wicked queen was obsessed with her beauty and asked her magic mirror every day who was the fairest of them all. When the mirror revealed that Snow White, the young princess, was the fairest in the land, the queen became envious and decided to get rid of Snow White."));
        scenes.add(new Scene(R.drawable.scenesnowhite, "The queen sent a huntsman to kill Snow White in the forest, but the huntsman took pity on her and let her go. Snow White stumbled upon a small cottage and went inside to rest, unaware that the cottage belonged to seven dwarfs who worked in the nearby mines."));
        scenes.add(new Scene(R.drawable.scenesnowhite, "The dwarfs were surprised to find Snow White in their home, but they welcomed her and allowed her to stay with them. Snow White promised to keep their house clean and tidy in exchange for their kindness."));
        scenes.add(new Scene(R.drawable.scenesnowhite, "The queen discovered that Snow White was still alive and decided to take matters into her own hands. She disguised herself as an old woman and offered Snow White a poisoned apple, which Snow White foolishly ate and fell into a deep sleep."));
        scenes.add(new Scene(R.drawable.scenesnowhite, "The dwarfs found Snow White and placed her in a glass coffin. They grieved her loss and guarded her from the queen. One day, a prince came to the forest and saw Snow White in her glass coffin. He kissed her, and she woke up from her slumber."));
        scenes.add(new Scene(R.drawable.scenesnowhite, "The queen was invited to the wedding of the prince and Snow White and was forced to dance in red-hot iron shoes until she died. Snow White and the prince lived happily ever after."));
        return scenes;
    }

    private List<Scene> createScenesForStory4(){
        List<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene(R.drawable.scenejunglebook, "Mowgli, a human child abandoned in the jungle and adopted by a wolf pack.Show Mowgli's interactions with his wolf family and his friendship with Bagheera, the wise black panther who becomes his mentor and protector."));
        scenes.add(new Scene(R.drawable.scenejunglebook, "Mowgli encounters Baloo, a fun-loving and carefree bear. Baloo teaches Mowgli the \"Bare Necessities\" of life and the importance of enjoying oneself."));
        scenes.add(new Scene(R.drawable.scenejunglebook, "Mowgli crosses paths with Kaa, a hypnotic python. Kaa tries to capture Mowgli by hypnotizing him, but Mowgli is rescued by Bagheera."));
        scenes.add(new Scene(R.drawable.scenejunglebook, "Shere Khan, a fearsome tiger, threatens the jungle animals, especially Mowgli. The animals hold a council to decide Mowgli's fate, and it is decided that he must leave the jungle for his safety."));
        scenes.add(new Scene(R.drawable.scenejunglebook, "Mowgli is captured by the mischievous monkeys called the Bandar-log. He is taken to their ancient ruins where he encounters the clever and manipulative King Louie, an orangutan who desires to learn the secret of fire from Mowgli."));
        scenes.add(new Scene(R.drawable.scenejunglebook, "Mowgli, Baloo, and Bagheera join forces to protect the jungle from Shere Khan's tyranny. With the help of his animal friends, Mowgli confronts and defeats Shere Khan, ultimately proving himself to be a brave and capable protector of the jungle."));
        scenes.add(new Scene(R.drawable.scenejunglebook, "Mowgli faces a difficult decision: whether to remain in the jungle or return to the human village. Mowgli realizes that he belongs with his own kind and decides to leave the jungle, bidding farewell to his animal friends."));
        scenes.add(new Scene(R.drawable.scenejunglebook, "Mowgli returns to the human village, where he is joyfully reunited with his long-lost family. He embarks on a new chapter of his life, carrying with him the lessons and memories from his time in the jungle."));
        return scenes;
    }

    private List<Scene> createScenesForStory5(){
        List<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene(R.drawable.alicescene, "Alice follows a white rabbit down a rabbit hole, entering a strange and whimsical world. She grows smaller and larger, experiences peculiar sensations, and finds herself in a hallway with many locked doors."));
        scenes.add(new Scene(R.drawable.alicescene, "Alice shrinks to a tiny size and finds herself swimming in her own tears. She meets a Mouse and other creatures who share their stories, and they all head to the shore"));
        scenes.add(new Scene(R.drawable.alicescene, "Alice participates in a Caucus Race organized by the Dodo to get dry. The race has no clear winner, and everyone is declared a winner by the Dodo."));
        scenes.add(new Scene(R.drawable.alicescene, "Alice stumbles upon the Mad Hatter, the March Hare, and the Dormouse having a never-ending tea party. She engages in nonsensical conversations and experiences time behaving unusually."));
        scenes.add(new Scene(R.drawable.alicescene, "Alice encounters the enigmatic Cheshire Cat, known for its mischievous grin and disappearing tricks. The cat offers cryptic advice and guides Alice on her journey."));
        scenes.add(new Scene(R.drawable.alicescene, "Alice finds herself in the Queen of Hearts' court, where a croquet game is in progress. The Queen, along with the King and various animal characters, engages in absurd and chaotic proceedings."));
        scenes.add(new Scene(R.drawable.alicescene, "Alice meets the Mock Turtle and the Gryphon, who share their melancholic and fantastical tales. They discuss subjects like education, poetry, and strange creatures in the sea."));
        scenes.add(new Scene(R.drawable.alicescene, "Alice attends a bizarre trial where the Knave of Hearts is accused of stealing tarts. The court proceedings are chaotic, filled with nonsense, and Alice finds herself growing larger and smaller again."));
        scenes.add(new Scene(R.drawable.alicescene, "Alice realizes the absurdity of Wonderland and rebels against the irrationality. She manages to escape the trial and awakens to find herself back in the real world, questioning the reality of her adventure."));
        return scenes;
    }

    private List<Scene> createScenesForStory6(){
        List<Scene> scenes = new ArrayList<>();
        scenes.add(new Scene(R.drawable.peterpanscene, "Introduce the Darling family, including Wendy, John, and Michael. Show their longing for adventure and their belief in the stories of Peter Pan."));
        scenes.add(new Scene(R.drawable.peterpanscene, "Peter Pan enters the Darling children's nursery through the window. He invites Wendy, John, and Michael to fly with him to Neverland, a magical island where children never grow up."));
        scenes.add(new Scene(R.drawable.peterpanscene, "The children arrive in Neverland and meet the Lost Boys, a group of boys who also never grew up. Peter Pan introduces them to the wonders of Neverland, including mermaids, fairies, and the fearsome Captain Hook."));
        scenes.add(new Scene(R.drawable.peterpanscene, "Introduce Captain Hook, the infamous pirate and Peter Pan's arch-nemesis. Show the ongoing battle between Peter Pan and Captain Hook, as Hook seeks revenge and Peter protects the Lost Boys."));
        scenes.add(new Scene(R.drawable.peterpanscene, "Introduce Tinker Bell, Peter Pan's feisty fairy companion. Show the significance of fairy dust, which allows Peter Pan and others to fly."));
        scenes.add(new Scene(R.drawable.peterpanscene, "Wendy takes on a motherly role for the Lost Boys, telling them stories and taking care of them. The children have various adventures in Neverland, including encounters with mermaids, Native Americans, and the ticking crocodile."));
        scenes.add(new Scene(R.drawable.peterpanscene, "Wendy is captured by Captain Hook, who believes she can lead him to Peter Pan's hideout. Peter Pan and the Lost Boys embark on a daring rescue mission to save Wendy from Hook's clutches."));
        scenes.add(new Scene(R.drawable.peterpanscene, "Peter Pan confronts Captain Hook in a climactic showdown. With the help of his friends and his wit, Peter Pan defeats Hook and saves the day."));
        scenes.add(new Scene(R.drawable.peterpanscene, "Peter Pan and the Darling children return to London, bidding farewell to Neverland. The children reunite with their parents, who believe they had a grand adventure in their dreams."));
        scenes.add(new Scene(R.drawable.peterpanscene, "Peter Pan visits the Darling children one last time, offering them a chance to return to Neverland. Wendy decides to stay behind, and Peter Pan flies off into the night, continuing his eternal childhood."));
        return scenes;
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.check_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.chek_list) {
            Intent intent = new Intent(StoriesActivity.this, FavoritesActivity.class);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }
}