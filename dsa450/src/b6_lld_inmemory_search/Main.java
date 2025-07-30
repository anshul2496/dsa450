package b6_lld_inmemory_search;

import java.util.List;

import b6_lld_inmemory_search.constants.ResultOrderType;
import b6_lld_inmemory_search.constants.SearchType;
import b6_lld_inmemory_search.constants.SortOrderType;

/*
 * https://medium.com/@choudharys710/lld-machine-coding-with-java-implementation-in-memory-search-engine-1fefdd9a4e4a
 */
public class Main {
	public static void main(String[] args) {
		TechBlogEngine techBlogEngine = TechBlogEngine.getInstance();

		techBlogEngine.createCategory("General Tech Articles");
		techBlogEngine.createCategory("AI/ML Articles");
		techBlogEngine.createCategory("Blockchain Articles");

		techBlogEngine.addDocumentToCategory("AI/ML Articles",
				"Deep understanding of Neural Networks and Reinforcement Learning",
				"Deep understanding of Neural Networks and Reinforcement Learning.", "John Doe 1");

		techBlogEngine.addDocumentToCategory("AI/ML Articles", "A Beginner's Guide to Machine Learning Models",
				"A Beginner's Guide to Machine Learning Models.", "John Doe 2");

		techBlogEngine.addDocumentToCategory("AI/ML Articles", "Deep Learning in Computer Vision: Use Cases and Future",
				"Deep Learning in Computer Vision: Use Cases and Future.", "John Doe 3");

		techBlogEngine.addDocumentToCategory("AI/ML Articles",
				"Exploring Reinforcement Learning with Practical Examples",
				"Exploring Reinforcement Learning with Practical Examples.", "John Doe 4");

		techBlogEngine.addDocumentToCategory("AI/ML Articles",
				"Reinforcement Learning and applications of Deep Neural Networks in Healthcare",
				"Reinforcement Learning and applications of Deep Neural Networks in Healthcare.", "John Doe 5");

		List<Document> documentList = techBlogEngine.search("AI/ML Articles", "Deep Learning", SearchType.UNORDERED,
				ResultOrderType.RECENTLY_PUBLISHED, SortOrderType.ASC);
		System.out.println("Unordered search results for 'Deep Learning' in 'AI/ML Articles' category:");
		for (Document document : documentList) {
			System.out.println(document.getName());
		}

		/*
		 * documentList = techBlogEngine.search("AI/ML Articles", "Deep Learning",
		 * SearchType.SUBSTRING, ResultOrderType.AUTHOR_NAME, SortOrderType.ASC);
		 * System.out.
		 * println("\nSubstring search results for 'Deep Learning' in 'AI/ML Articles' category:"
		 * ); for (Document document : documentList) {
		 * System.out.println(document.getName()); }
		 */
	}
}
