package com.festember.festember16;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.ProgressBar;

import com.google.gson.Gson;

import java.util.List;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class ListActivity extends AppCompatActivity {

    public static final String LOG_TAG = "ListActivity";
    public static final String EVENT = "Event";
    public static final String API_RESPONSE = "{\"status\":2,\"data\":[{\"event_id\":\"2\",\"event_name\":\"choreo_nite_eastern\",\"event_start_time\":\"16:30:00\",\"event_end_time\":\"21:30:00\",\"event_venue\":\"OAT\",\"event_last_update_time\":\"03:16:16\",\"event_loc_x\":\"78.817\",\"event_loc_y\":\"10.7646\",\"event_max_limit\":\"0\",\"event_cluster\":\"dance\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"3\",\"event_name\":\"choreo_nite_western\",\"event_start_time\":\"16:30:00\",\"event_end_time\":\"21:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"05:38:30\",\"event_loc_x\":\"78.8181\",\"event_loc_y\":\"10.7645\",\"event_max_limit\":\"0\",\"event_cluster\":\"dance\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"4\",\"event_name\":\"western_free_style_solo\",\"event_start_time\":\"12:00:00\",\"event_end_time\":\"16:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"04:08:29\",\"event_loc_x\":\"78.8178\",\"event_loc_y\":\"10.7659\",\"event_max_limit\":\"0\",\"event_cluster\":\"dance\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"5\",\"event_name\":\"eastern_solo_free_style\",\"event_start_time\":\"10:00:00\",\"event_end_time\":\"12:00:00\",\"event_venue\":\"EEE\",\"event_last_update_time\":\"03:35:00\",\"event_loc_x\":\"78.8162\",\"event_loc_y\":\"10.7644\",\"event_max_limit\":\"0\",\"event_cluster\":\"dance\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"6\",\"event_name\":\"duet_freestyle\",\"event_start_time\":\"12:00:00\",\"event_end_time\":\"16:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"04:12:01\",\"event_loc_x\":\"78.8171\",\"event_loc_y\":\"10.7641\",\"event_max_limit\":\"0\",\"event_cluster\":\"dance\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"7\",\"event_name\":\"tarangini\",\"event_start_time\":\"09:00:00\",\"event_end_time\":\"14:00:00\",\"event_venue\":\"OAT\",\"event_last_update_time\":\"16:20:08\",\"event_loc_x\":\"78.8178\",\"event_loc_y\":\"10.7654\",\"event_max_limit\":\"0\",\"event_cluster\":\"music\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"8\",\"event_name\":\"gig_a_hertz\",\"event_start_time\":\"09:00:00\",\"event_end_time\":\"14:00:00\",\"event_venue\":\"The Ark\",\"event_last_update_time\":\"04:15:54\",\"event_loc_x\":\"78.8167\",\"event_loc_y\":\"10.764\",\"event_max_limit\":\"0\",\"event_cluster\":\"music\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"9\",\"event_name\":\"acoustics\",\"event_start_time\":\"09:00:00\",\"event_end_time\":\"16:30:00\",\"event_venue\":\"EEE\",\"event_last_update_time\":\"04:21:16\",\"event_loc_x\":\"78.8176\",\"event_loc_y\":\"10.7645\",\"event_max_limit\":\"0\",\"event_cluster\":\"music\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"10\",\"event_name\":\"a-capella\",\"event_start_time\":\"09:30:00\",\"event_end_time\":\"16:30:00\",\"event_venue\":\"EEE\",\"event_last_update_time\":\"04:23:50\",\"event_loc_x\":\"78.8176\",\"event_loc_y\":\"10.7647\",\"event_max_limit\":\"0\",\"event_cluster\":\"music\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"11\",\"event_name\":\"carnatic_vocals_solo\",\"event_start_time\":\"09:00:00\",\"event_end_time\":\"11:30:00\",\"event_venue\":\"A2\",\"event_last_update_time\":\"05:54:20\",\"event_loc_x\":\"78.8169\",\"event_loc_y\":\"10.7637\",\"event_max_limit\":\"0\",\"event_cluster\":\"shruthilaya\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"12\",\"event_name\":\"carnatic_instrumental_percussion\",\"event_start_time\":\"14:30:00\",\"event_end_time\":\"15:30:00\",\"event_venue\":\"A2\",\"event_last_update_time\":\"04:26:48\",\"event_loc_x\":\"78.817\",\"event_loc_y\":\"10.7631\",\"event_max_limit\":\"0\",\"event_cluster\":\"shruthilaya\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"13\",\"event_name\":\"group_performance\",\"event_start_time\":\"13:30:00\",\"event_end_time\":\"14:30:00\",\"event_venue\":\"A2\",\"event_last_update_time\":\"04:27:48\",\"event_loc_x\":\"78.8154\",\"event_loc_y\":\"10.7643\",\"event_max_limit\":\"0\",\"event_cluster\":\"shruthilaya\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"14\",\"event_name\":\"carnatic_instrumental_non_percus\",\"event_start_time\":\"11:30:00\",\"event_end_time\":\"12:30:00\",\"event_venue\":\"A2\",\"event_last_update_time\":\"05:58:14\",\"event_loc_x\":\"78.8179\",\"event_loc_y\":\"10.7644\",\"event_max_limit\":\"0\",\"event_cluster\":\"shruthilaya\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"17\",\"event_name\":\"theatrix\",\"event_start_time\":\"09:00:00\",\"event_end_time\":\"17:30:00\",\"event_venue\":\"EEE\",\"event_last_update_time\":\"04:30:25\",\"event_loc_x\":\"78.8159\",\"event_loc_y\":\"10.763\",\"event_max_limit\":\"0\",\"event_cluster\":\"dramatics\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"18\",\"event_name\":\"act_a_thon\",\"event_start_time\":\"18:30:00\",\"event_end_time\":\"19:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"06:00:32\",\"event_loc_x\":\"78.8166\",\"event_loc_y\":\"10.7634\",\"event_max_limit\":\"0\",\"event_cluster\":\"dramatics\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"19\",\"event_name\":\"ad_film_making\",\"event_start_time\":\"20:30:00\",\"event_end_time\":\"21:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"06:01:19\",\"event_loc_x\":\"78.8162\",\"event_loc_y\":\"10.7635\",\"event_max_limit\":\"0\",\"event_cluster\":\"cinematics\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"20\",\"event_name\":\"fashionitas\",\"event_start_time\":\"10:00:00\",\"event_end_time\":\"17:00:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"16:38:38\",\"event_loc_x\":\"78.8171\",\"event_loc_y\":\"10.7634\",\"event_max_limit\":\"0\",\"event_cluster\":\"fashionitas\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"21\",\"event_name\":\"dota_2\",\"event_start_time\":\"09:00:00\",\"event_end_time\":\"17:30:00\",\"event_venue\":\"Orion SF 4,5,6\",\"event_last_update_time\":\"04:43:35\",\"event_loc_x\":\"78.8146\",\"event_loc_y\":\"10.7639\",\"event_max_limit\":\"0\",\"event_cluster\":\"gaming\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"22\",\"event_name\":\"fifa\",\"event_start_time\":\"20:30:00\",\"event_end_time\":\"00:30:00\",\"event_venue\":\"A11\",\"event_last_update_time\":\"04:45:28\",\"event_loc_x\":\"78.818\",\"event_loc_y\":\"10.7645\",\"event_max_limit\":\"0\",\"event_cluster\":\"gaming\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"23\",\"event_name\":\"CS\",\"event_start_time\":\"09:00:00\",\"event_end_time\":\"17:30:00\",\"event_venue\":\"SF Orion SF 4,5,6\",\"event_last_update_time\":\"04:46:34\",\"event_loc_x\":\"78.8178\",\"event_loc_y\":\"10.7643\",\"event_max_limit\":\"0\",\"event_cluster\":\"gaming\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"24\",\"event_name\":\"blur\",\"event_start_time\":\"20:30:00\",\"event_end_time\":\"00:30:00\",\"event_venue\":\"A11\",\"event_last_update_time\":\"04:48:51\",\"event_loc_x\":\"78.8172\",\"event_loc_y\":\"10.7592\",\"event_max_limit\":\"0\",\"event_cluster\":\"gaming\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"25\",\"event_name\":\"wall_painting\",\"event_start_time\":\"10:00:00\",\"event_end_time\":\"13:00:00\",\"event_venue\":\"The Ark\",\"event_last_update_time\":\"04:50:18\",\"event_loc_x\":\"78.8169\",\"event_loc_y\":\"10.766\",\"event_max_limit\":\"0\",\"event_cluster\":\"arts\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"26\",\"event_name\":\"shadow_art\",\"event_start_time\":\"09:30:00\",\"event_end_time\":\"11:30:00\",\"event_venue\":\"Archi Dept 3\",\"event_last_update_time\":\"04:55:18\",\"event_loc_x\":\"78.8136\",\"event_loc_y\":\"10.7642\",\"event_max_limit\":\"0\",\"event_cluster\":\"arts\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"27\",\"event_name\":\"face_painting\",\"event_start_time\":\"14:00:00\",\"event_end_time\":\"16:00:00\",\"event_venue\":\"Archi Dept 3\",\"event_last_update_time\":\"06:05:17\",\"event_loc_x\":\"78.8175\",\"event_loc_y\":\"10.7659\",\"event_max_limit\":\"0\",\"event_cluster\":\"arts\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"29\",\"event_name\":\"abstract_painting\",\"event_start_time\":\"14:00:00\",\"event_end_time\":\"15:30:00\",\"event_venue\":\"Arch studio 3\",\"event_last_update_time\":\"05:01:08\",\"event_loc_x\":\"78.8165\",\"event_loc_y\":\"10.7608\",\"event_max_limit\":\"0\",\"event_cluster\":\"arts\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"30\",\"event_name\":\"collage\",\"event_start_time\":\"14:00:00\",\"event_end_time\":\"16:00:00\",\"event_venue\":\"Archi studio 3\",\"event_last_update_time\":\"05:03:27\",\"event_loc_x\":\"78.8168\",\"event_loc_y\":\"10.7597\",\"event_max_limit\":\"0\",\"event_cluster\":\"arts\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"31\",\"event_name\":\"mask_making\",\"event_start_time\":\"09:30:00\",\"event_end_time\":\"11:30:00\",\"event_venue\":\"Archi studio 3\",\"event_last_update_time\":\"05:06:11\",\"event_loc_x\":\"78.8154\",\"event_loc_y\":\"10.7622\",\"event_max_limit\":\"0\",\"event_cluster\":\"arts\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"32\",\"event_name\":\"bollywood_quiz\",\"event_start_time\":\"12:00:00\",\"event_end_time\":\"13:30:00\",\"event_venue\":\"Orion Ng 9\",\"event_last_update_time\":\"06:07:26\",\"event_loc_x\":\"78.8176\",\"event_loc_y\":\"10.7635\",\"event_max_limit\":\"0\",\"event_cluster\":\"hindilits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"33\",\"event_name\":\"bluffmaster\",\"event_start_time\":\"14:30:00\",\"event_end_time\":\"16:00:00\",\"event_venue\":\"Orion Sg3\",\"event_last_update_time\":\"05:18:50\",\"event_loc_x\":\"78.8106\",\"event_loc_y\":\"10.7667\",\"event_max_limit\":\"0\",\"event_cluster\":\"hindilits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"34\",\"event_name\":\"extempore_speech\",\"event_start_time\":\"11:30:00\",\"event_end_time\":\"13:30:00\",\"event_venue\":\"A13\",\"event_last_update_time\":\"05:23:56\",\"event_loc_x\":\"78.8168\",\"event_loc_y\":\"10.7622\",\"event_max_limit\":\"0\",\"event_cluster\":\"hindilits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"35\",\"event_name\":\"dumb_c\",\"event_start_time\":\"14:30:00\",\"event_end_time\":\"17:30:00\",\"event_venue\":\"A13\",\"event_last_update_time\":\"05:25:34\",\"event_loc_x\":\"78.8155\",\"event_loc_y\":\"10.7655\",\"event_max_limit\":\"0\",\"event_cluster\":\"hindilits\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"36\",\"event_name\":\"rochak_mantrana\",\"event_start_time\":\"09:00:00\",\"event_end_time\":\"17:30:00\",\"event_venue\":\"PR dEsk\",\"event_last_update_time\":\"05:27:14\",\"event_loc_x\":\"78.8146\",\"event_loc_y\":\"10.7656\",\"event_max_limit\":\"0\",\"event_cluster\":\"hindilits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"37\",\"event_name\":\"online_creative_writing\",\"event_start_time\":\"15:30:00\",\"event_end_time\":\"16:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"06:09:56\",\"event_loc_x\":\"78.8172\",\"event_loc_y\":\"10.7644\",\"event_max_limit\":\"0\",\"event_cluster\":\"hindilits\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"38\",\"event_name\":\"grammar_quiz\",\"event_start_time\":\"10:00:00\",\"event_end_time\":\"12:00:00\",\"event_venue\":\"A12\",\"event_last_update_time\":\"05:28:43\",\"event_loc_x\":\"78.8145\",\"event_loc_y\":\"10.7593\",\"event_max_limit\":\"0\",\"event_cluster\":\"hindilits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"39\",\"event_name\":\"chakravyuh\",\"event_start_time\":\"16:00:00\",\"event_end_time\":\"17:30:00\",\"event_venue\":\"Orion Ng 7\",\"event_last_update_time\":\"17:06:59\",\"event_loc_x\":\"78.8162\",\"event_loc_y\":\"10.761\",\"event_max_limit\":\"0\",\"event_cluster\":\"hindilits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"40\",\"event_name\":\"lone_wolf_quiz\",\"event_start_time\":\"20:30:00\",\"event_end_time\":\"22:00:00\",\"event_venue\":\"A2\",\"event_last_update_time\":\"06:11:58\",\"event_loc_x\":\"78.8162\",\"event_loc_y\":\"10.7643\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"41\",\"event_name\":\"splitent_quiz\",\"event_start_time\":\"20:00:00\",\"event_end_time\":\"22:00:00\",\"event_venue\":\"A13 hall\",\"event_last_update_time\":\"05:50:42\",\"event_loc_x\":\"78.8176\",\"event_loc_y\":\"10.7653\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"42\",\"event_name\":\"india_quiz\",\"event_start_time\":\"10:00:00\",\"event_end_time\":\"11:30:00\",\"event_venue\":\"A13\",\"event_last_update_time\":\"05:58:42\",\"event_loc_x\":\"78.8167\",\"event_loc_y\":\"10.7637\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"43\",\"event_name\":\"av_quiz\",\"event_start_time\":\"13:00:00\",\"event_end_time\":\"15:00:00\",\"event_venue\":\"A2\",\"event_last_update_time\":\"06:19:55\",\"event_loc_x\":\"78.8149\",\"event_loc_y\":\"10.7659\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"44\",\"event_name\":\"buzzer_quiz\",\"event_start_time\":\"11:00:00\",\"event_end_time\":\"12:30:00\",\"event_venue\":\"Orion Sg2\",\"event_last_update_time\":\"06:04:17\",\"event_loc_x\":\"78.8168\",\"event_loc_y\":\"10.7642\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"45\",\"event_name\":\"jam\",\"event_start_time\":\"14:30:00\",\"event_end_time\":\"16:30:00\",\"event_venue\":\"A2 Hall\",\"event_last_update_time\":\"05:57:37\",\"event_loc_x\":\"78.8151\",\"event_loc_y\":\"10.7656\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"46\",\"event_name\":\"dumb_charades\",\"event_start_time\":\"07:00:00\",\"event_end_time\":\"09:00:00\",\"event_venue\":\"A hall\",\"event_last_update_time\":\"06:06:03\",\"event_loc_x\":\"78.8172\",\"event_loc_y\":\"10.7638\",\"event_max_limit\":\"0\",\"event_cluster\":\"englits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"47\",\"event_name\":\"debate\",\"event_start_time\":\"17:00:00\",\"event_end_time\":\"18:30:00\",\"event_venue\":\"A2 Hall\",\"event_last_update_time\":\"05:52:18\",\"event_loc_x\":\"78.8149\",\"event_loc_y\":\"10.7641\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"48\",\"event_name\":\"extempore\",\"event_start_time\":\"15:00:00\",\"event_end_time\":\"17:00:00\",\"event_venue\":\"A2 Hall\",\"event_last_update_time\":\"05:50:20\",\"event_loc_x\":\"78.8154\",\"event_loc_y\":\"10.7648\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"49\",\"event_name\":\"pot_pourri\",\"event_start_time\":\"12:30:00\",\"event_end_time\":\"14:30:00\",\"event_venue\":\"Orion NG-8\",\"event_last_update_time\":\"05:47:31\",\"event_loc_x\":\"78.815\",\"event_loc_y\":\"10.7646\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"50\",\"event_name\":\"whats_the_good_word\",\"event_start_time\":\"08:30:00\",\"event_end_time\":\"10:00:00\",\"event_venue\":\"A13\",\"event_last_update_time\":\"06:17:33\",\"event_loc_x\":\"78.8167\",\"event_loc_y\":\"10.7648\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"51\",\"event_name\":\"crossword\",\"event_start_time\":\"06:30:00\",\"event_end_time\":\"09:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"06:21:43\",\"event_loc_x\":\"78.8173\",\"event_loc_y\":\"10.7649\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"52\",\"event_name\":\"scrabble\",\"event_start_time\":\"17:30:00\",\"event_end_time\":\"19:00:00\",\"event_venue\":\"A13\",\"event_last_update_time\":\"05:27:40\",\"event_loc_x\":\"78.8169\",\"event_loc_y\":\"10.7646\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"53\",\"event_name\":\"puzzle_champ\",\"event_start_time\":\"08:00:00\",\"event_end_time\":\"09:30:00\",\"event_venue\":\"A13 hall\",\"event_last_update_time\":\"07:20:58\",\"event_loc_x\":\"78.8156\",\"event_loc_y\":\"10.7638\",\"event_max_limit\":\"0\",\"event_cluster\":\"englishlits\",\"event_date\":\"2015-09-27\"},{\"event_id\":\"54\",\"event_name\":\"villupaatu\",\"event_start_time\":\"14:00:00\",\"event_end_time\":\"16:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"05:21:54\",\"event_loc_x\":\"78.8176\",\"event_loc_y\":\"10.7646\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"55\",\"event_name\":\"kavithidal\",\"event_start_time\":\"12:30:00\",\"event_end_time\":\"14:00:00\",\"event_venue\":\"Orion Sg 4\",\"event_last_update_time\":\"17:19:43\",\"event_loc_x\":\"78.8171\",\"event_loc_y\":\"10.7645\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"56\",\"event_name\":\"kuraloviyam\",\"event_start_time\":\"16:00:00\",\"event_end_time\":\"18:30:00\",\"event_venue\":\"EEE Audi\",\"event_last_update_time\":\"05:18:48\",\"event_loc_x\":\"78.8156\",\"event_loc_y\":\"10.765\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"57\",\"event_name\":\"kolam\",\"event_start_time\":\"08:30:00\",\"event_end_time\":\"10:00:00\",\"event_venue\":\"SAC\",\"event_last_update_time\":\"03:32:52\",\"event_loc_x\":\"78.816\",\"event_loc_y\":\"10.7644\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"58\",\"event_name\":\"kodambakkam\",\"event_start_time\":\"17:30:00\",\"event_end_time\":\"18:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"17:21:45\",\"event_loc_x\":\"78.8179\",\"event_loc_y\":\"10.7645\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"59\",\"event_name\":\"kalakkal_kalatta\",\"event_start_time\":\"16:30:00\",\"event_end_time\":\"19:30:00\",\"event_venue\":\"Barn\",\"event_last_update_time\":\"05:09:23\",\"event_loc_x\":\"78.8148\",\"event_loc_y\":\"10.7636\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"60\",\"event_name\":\"kaatrodu_kadhai_pesava\",\"event_start_time\":\"15:30:00\",\"event_end_time\":\"18:30:00\",\"event_venue\":\"Orion Sg 4\",\"event_last_update_time\":\"06:27:44\",\"event_loc_x\":\"78.8164\",\"event_loc_y\":\"10.7634\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"62\",\"event_name\":\"sakalakala_vallavan\",\"event_start_time\":\"15:30:00\",\"event_end_time\":\"16:30:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"06:25:21\",\"event_loc_x\":\"78.8148\",\"event_loc_y\":\"10.7639\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"63\",\"event_name\":\"varthai_vilayattu\",\"event_start_time\":\"15:00:00\",\"event_end_time\":\"16:00:00\",\"event_venue\":\"Orion SG1\",\"event_last_update_time\":\"04:59:24\",\"event_loc_x\":\"78.8157\",\"event_loc_y\":\"10.7647\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-25\"},{\"event_id\":\"64\",\"event_name\":\"uyarthani_semmozhi\",\"event_start_time\":\"14:00:00\",\"event_end_time\":\"17:00:00\",\"event_venue\":\"Orion SG5\",\"event_last_update_time\":\"04:57:14\",\"event_loc_x\":\"78.8155\",\"event_loc_y\":\"10.7644\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-26\"},{\"event_id\":\"65\",\"event_name\":\"koothambalam\",\"event_start_time\":\"11:30:00\",\"event_end_time\":\"14:00:00\",\"event_venue\":\"barn\",\"event_last_update_time\":\"04:54:31\",\"event_loc_x\":\"78.8163\",\"event_loc_y\":\"10.764\",\"event_max_limit\":\"0\",\"event_cluster\":\"tamillits\",\"event_date\":\"2015-09-26\"}]}";
    public static List<Events> eventsData;

    @InjectView(R.id.listView)
    ListView listView;

    @InjectView(R.id.progressBar)
    ProgressBar progressBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ButterKnife.inject(this);

        Gson gson = new Gson();

        EventResponse response = gson.fromJson(API_RESPONSE, EventResponse.class);
        eventsData = response.getData();

        listView.setAdapter(
                new EventsAdapter(
                        ListActivity.this,
                        0,
                        eventsData)
        );

        listView.setOnItemClickListener(
                new AdapterView.OnItemClickListener() {
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

                        Intent intent = new Intent(
                                ListActivity.this,
                                DetailsActivity.class
                        );

                        Gson gson = new Gson();

                        intent.putExtra(EVENT, gson.toJson(eventsData.get(position)));

                        startActivity(intent);

                    }
                }
        );
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {

        getMenuInflater().inflate(
                R.menu.menu_list,
                menu
        );

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        switch(id){
            case R.id.action_profile:
                Intent intent = new Intent(ListActivity.this, MyProfile.class);
                startActivity(intent);
                break;
        }

        return super.onOptionsItemSelected(item);
    }
}

