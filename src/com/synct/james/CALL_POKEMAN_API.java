package com.synct.james;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.JSONArray;
import org.json.JSONObject;

public class CALL_POKEMAN_API {
	private static String poke_index_url = "https://pokeapi.co/api/v2/pokemon?limit=151&offset=0";//API_URL
	private static String set_language = "zh-Hant";//語言(固定)
	private static String set_version = "sword";//遊戲版本
	//(lets-go-pikachu || lets-go-eevee || sword ||shield)
	private static String set_version_group = "sword-shield";//遊戲版本_群組
	//(sun-moon || ultra-sun-ultra-moon || sword-shield)
	
	//https://jsoneditoronline.org/#right=local.yixipi&left=local.jogeta
	
	public static void main(String[] args) {
		try {
			JSONObject pokeman_index = get_json(poke_index_url);
			JSONArray pokeman_list = pokeman_index.getJSONArray("results");
			
			for(int i=0;i<pokeman_list.length();i++) {
				//https://pokeapi.co/api/v2/pokemon/1/
				JSONObject pokeman = pokeman_list.getJSONObject(i);
				JSONObject pokeman_info = get_json(pokeman.getString("url"));
				
				String id = String.format("%04d",pokeman_info.getInt("id"));//全國圖鑑ID
				//String name = pokeman_info.getString("name");//名稱(英文)
				String height = Integer.toString(pokeman_info.getInt("height"));//高度
				String weight = Integer.toString(pokeman_info.getInt("weight"));//重量
				
				JSONObject species = pokeman_info.getJSONObject("species");//物種
				JSONArray types = pokeman_info.getJSONArray("types");//屬性
				JSONArray abilities = pokeman_info.getJSONArray("abilities");//能力
				
				JSONArray moves = pokeman_info.getJSONArray("moves");//招式
				JSONObject sprites = pokeman_info.getJSONObject("sprites");//圖片
				JSONArray stats = pokeman_info.getJSONArray("stats");//能力值
				
				//JSONArray forms = pokeman_info.getJSONArray("forms");//形式
				//JSONArray game_indices = pokeman_info.getJSONArray("game_indices");//歷代圖鑑編號
				//JSONArray held_items = pokeman_info.getJSONArray("held_items");//持有物品
				
				
				//----print----
				System.out.println("全國圖鑑編號=>" + id);
				System.out.println("身高=>" + height);
				System.out.println("體重=>" + weight);
				
				//物種
				get_species(get_json(species.getString("url")));
				
				//屬性
				for(int j=0;j<types.length();j++) {
					JSONObject jsob = types.getJSONObject(j);
					JSONObject type = jsob.getJSONObject("type");
					String type_url = type.getString("url");
	
					get_types(get_json(type_url),j+1);
				}
				
				//能力
				for(int j=0;j<abilities.length();j++) {
					JSONObject jsob = abilities.getJSONObject(j);
					JSONObject ability = jsob.getJSONObject("ability");
					String ability_url = ability.getString("url");
					Boolean is_hidden = jsob.getBoolean("is_hidden");//是否為夢特性
					
					get_abilities(get_json(ability_url),j+1);
					
					System.out.println("是否為夢特性_"+(j+1)+"=>" + is_hidden);
				}
				
				
				

				
				System.out.println("----------------");
				break;
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	
	private static void get_abilities(JSONObject abilities,int count) {
		try {
			//https://pokeapi.co/api/v2/ability/65/
			JSONArray names = abilities.getJSONArray("names");//寶可夢特性名稱
			JSONArray flavor_text_entries = abilities.getJSONArray("flavor_text_entries");//寶可夢特性說明
			
			//names
			for(int j=0;j<names.length();j++) {
				JSONObject jsob = names.getJSONObject(j);
				String name = jsob.getString("name");
				String language = jsob.getJSONObject("language").getString("name");
				if(set_language.equals(language)) {
					System.out.println("特性_"+count+"=>" + name);
					break;
				}
			}
			
			//flavor_text_entries
			for(int j=0;j<flavor_text_entries.length();j++) {
				JSONObject jsob = flavor_text_entries.getJSONObject(j);
				String flavor_text = jsob.getString("flavor_text").replaceAll("\r","").replaceAll("\n","");
				String language = jsob.getJSONObject("language").getString("name");
				String version_group = jsob.getJSONObject("version_group").getString("name");
				if(set_language.equals(language) && set_version_group.equals(version_group)) {
					System.out.println("特性說明_"+count+"=>" + flavor_text);
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void get_types(JSONObject types,int count) {
		try {
			//https://pokeapi.co/api/v2/type/12/
			JSONArray names = types.getJSONArray("names");//寶可夢屬性
			
			//names
			for(int j=0;j<names.length();j++) {
				JSONObject jsob = names.getJSONObject(j);
				String name = jsob.getString("name");
				String language = jsob.getJSONObject("language").getString("name");
				if(set_language.equals(language)) {
					System.out.println("寶可夢屬性_"+count+"=>" + name);
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void get_species(JSONObject species) {
		try {
			//https://pokeapi.co/api/v2/pokemon-species/1/
			JSONArray names = species.getJSONArray("names");//寶可夢名稱
			JSONArray genera = species.getJSONArray("genera");//寶可夢種類
			JSONArray flavor_text_entries = species.getJSONArray("flavor_text_entries");//寶可夢說明
			//no_use
			String evolution_chain_url = species.getJSONObject("evolution_chain").getString("url");//寶可夢進化鏈
			JSONArray egg_groups = species.getJSONArray("egg_groups");//寶可夢蛋群
			JSONArray pokedex_numbers = species.getJSONArray("pokedex_numbers");//寶可夢歷代圖鑑編號
			
			//names
			for(int i=0;i<names.length();i++) {
				JSONObject f_jsob = names.getJSONObject(i);
				String name = f_jsob.getString("name");
				String language = f_jsob.getJSONObject("language").getString("name");
				if(set_language.equals(language)) {
					System.out.println("寶可夢名稱=>" + name);
					break;
				}
			}
			//genera
			for(int i=0;i<genera.length();i++) {
				JSONObject f_jsob = genera.getJSONObject(i);
				String genus = f_jsob.getString("genus");
				String language = f_jsob.getJSONObject("language").getString("name");
				if(set_language.equals(language)) {
					System.out.println("寶可夢種類=>" + genus);
					break;
				}
			}
			//flavor_text_entries
			for(int i=0;i<flavor_text_entries.length();i++) {
				JSONObject f_jsob = flavor_text_entries.getJSONObject(i);
				String flavor_text = f_jsob.getString("flavor_text").replaceAll("\r","").replaceAll("\n","");
				String language = f_jsob.getJSONObject("language").getString("name");
				String version = f_jsob.getJSONObject("version").getString("name");
				if(set_language.equals(language) && set_version.equals(version)) {
					System.out.println("寶可夢說明=>" + flavor_text);
					break;
				}
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private static JSONObject get_json(String url) {
		JSONObject jsob = null;
		try {
			URL wsUrl = new URL(url);
			HttpURLConnection conn = (HttpURLConnection) wsUrl.openConnection();
			conn.setRequestMethod("GET");
	        conn.setRequestProperty("User-Agent", "Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.11 (KHTML, like Gecko) Chrome/23.0.1271.95 Safari/537.11");
	        conn.setRequestProperty("Content-Type", "application/json");
			conn.connect();
		
			//System.err.println("status=>" + conn.getResponseCode());
			//System.err.println("Message=>" + conn.getResponseMessage());
			
			InputStream is = conn.getInputStream();
			InputStreamReader isr = new InputStreamReader(is, "UTF-8");
			BufferedReader reader = new BufferedReader(isr);
			StringBuilder result = new StringBuilder();
			String lines;
			while ((lines = reader.readLine()) != null) {
				result.append(lines);
			}
			jsob = new JSONObject(result.toString());
			
			reader.close();
			isr.close();
			is.close();
			conn.disconnect();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return jsob;
	}
	
}
