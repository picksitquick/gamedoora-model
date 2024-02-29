package com.gamedoora.model.mapper;

import com.gamedoora.model.dao.IssueHistory;
import com.gamedoora.model.dto.IssueHistoryDTO;
import org.mapstruct.Builder;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring" , builder = @Builder(disableBuilder = true))
public abstract class IssueHistoryMapper extends BaseMapper{

    public abstract IssueHistoryDTO issueHistoryToIssueHistoryDTO(IssueHistory issueHistory);

    public abstract IssueHistory issueHistoryDTOToIssueHistory(IssueHistoryDTO issueHistoryDTO);
}
