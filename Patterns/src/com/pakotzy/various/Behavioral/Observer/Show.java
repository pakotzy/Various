package com.pakotzy.various.Behavioral.Observer;

public class Show {
	private String name;
	private Integer lastSeason;
	private Integer lastEpisode;
	private String nextEpisodeDate;

	public Show(String name, Integer lastSeason, Integer lastEpisode, String nextEpisodeDate) {
		this.name = name;
		this.lastSeason = lastSeason;
		this.lastEpisode = lastEpisode;
		this.nextEpisodeDate = nextEpisodeDate;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String toString() {
		return "Show{" +
				"name='" + name + '\'' +
				", lastSeason=" + lastSeason +
				", lastEpisode=" + lastEpisode +
				", nextEpisodeDate='" + nextEpisodeDate + '\'' +
				'}';
	}

	public Integer getLastSeason() {
		return lastSeason;
	}

	public void setLastSeason(Integer lastSeason) {
		this.lastSeason = lastSeason;
	}

	public Integer getLastEpisode() {
		return lastEpisode;
	}

	public void setLastEpisode(Integer lastEpisode) {
		this.lastEpisode = lastEpisode;
	}

	public String getNextEpisodeDate() {
		return nextEpisodeDate;
	}

	public void setNextEpisodeDate(String nextEpisodeDate) {
		this.nextEpisodeDate = nextEpisodeDate;
	}
}
