package com.chothuenhatro.utils;

import org.apache.commons.lang.StringUtils;
import org.displaytag.tags.TableTagParameters;
import org.displaytag.util.ParamEncoder;

import com.chothuenhatro.dto.AbstractDTO;

import javax.servlet.http.HttpServletRequest;

public class DisplayTagUtils {

    public static void of(HttpServletRequest request, AbstractDTO dto) {
        if (dto != null) {
            String sPage = request.getParameter(new ParamEncoder(dto.getTableId()).encodeParameterName(TableTagParameters.PARAMETER_PAGE));
            Integer page = 1;
            if (StringUtils.isNotBlank(sPage)) {
                try {
                    page = Integer.valueOf(sPage);
                } catch (Exception e) {
                    //log
                }
            }
            dto.setPage(page);
        }
    }
}
