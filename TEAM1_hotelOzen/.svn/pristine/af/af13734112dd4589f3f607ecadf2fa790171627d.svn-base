package kr.or.ddit.global.common.paging;

public class BootstrapFormBasePaginationRenderer extends AbstractFormBasePaginationRenderer {

	public BootstrapFormBasePaginationRenderer() {
		this("#pagingForm");
	}
	
	public BootstrapFormBasePaginationRenderer(String targetForm) {
		super(targetForm);
	}

	@Override
	public String renderPagination(PaginationInfo paging) {
		
		String preBtn = "<a class='btn btn-sm btn-falcon-default me-1 %s' type='button'"
		+ "					title='Previous' data-list-pagination='prev'"
		+ "					href='javascript:;' data-pg-role='pageLink' data-pg-page='%d' data-pg-target='"+ getTargetForm() +"'>"
		+ "					<span class='fas fa-chevron-left'></span>"
		+ "				</a>";
		
		String aTagPtrn ="<li><a class='page' data-i='%d' data-page='%d' "
				+ "href='javascript:;' data-pg-role='pageLink' "
				+ "data-pg-page='%d'data-pg-target='"+ getTargetForm() +"'>%s</a></li>";
		
		String cPagePtrn = "<li><a class='page active' data-i='%d' data-page='%d'"
				+ "href='javascript:;' data-pg-role='pageLink' "
				+ "data-pg-page='%d'data-pg-target='"+ getTargetForm() +"'>%s</a></li>";
		
		String postBtn = "<a class='btn btn-sm btn-falcon-default me-1 %s' type='button'"
		+ "					title='Previous' data-list-pagination='prev'"
		+ "					href='javascript:;' data-pg-role='pageLink' data-pg-page='%d' data-pg-target='"+ getTargetForm() +"'>"
		+ "					<span class='fas fa-chevron-right'></span>"
		+ "				</a>";
		
		int startPage = paging.getStartPage();
		int endPage = paging.getEndPage();
		int totalPage = paging.getTotalPage();
		int blockSize = paging.getBlockSize();
		int currentPage = paging.getCurrentPage();
				
		StringBuffer html = new StringBuffer();
				
//		이전페이지 부분 < //이전페이지가 없을경우 비활성화
		if(startPage > blockSize) {
			html.append(
					String.format(preBtn,"", startPage - blockSize)
			);
		}else {
			html.append(
					String.format(preBtn, "disabled", 1)
					);
		}
		
		html.append("<ul class='pagination mb-0'>");
//		페이지 숫자 부분
		for(int page = startPage; page <= endPage; page++) {
			if(page==currentPage) {
				html.append(
					String.format(cPagePtrn, page, page, page, page) //해당 페이지 	 
				);
			}else {
				html.append(
					String.format(aTagPtrn, page , page, page, page)	
				);
				
			}
			
		}
		
		html.append("</ul>");
		
//		다음페이지 부분 >
		if(endPage < totalPage) {
			html.append(
					String.format(postBtn, "", endPage + 1)	
			);
		}else {
			html.append(
					String.format(postBtn, "disabled", endPage + 1)	
			);
		}
		
		return html.toString();
	}

}
