package com.son.jawad.ui_widgets.Models;

import java.util.List;

/**
 * Created by Adhamkh on 2017-09-09.
 */

public class FileResult {
    public List<String> FileNames;
    public String Description;
    public String CreatedTimestamp;
    public String UpdatedTimestamp;
    public String DownloadLink;
    public List<String> ContentTypes;
    public List<String> Names;

    public List<String> getFileNames() {
        return FileNames;
    }

    public void setFileNames(List<String> fileNames) {
        FileNames = fileNames;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCreatedTimestamp() {
        return CreatedTimestamp;
    }

    public void setCreatedTimestamp(String createdTimestamp) {
        CreatedTimestamp = createdTimestamp;
    }

    public String getUpdatedTimestamp() {
        return UpdatedTimestamp;
    }

    public void setUpdatedTimestamp(String updatedTimestamp) {
        UpdatedTimestamp = updatedTimestamp;
    }

    public String getDownloadLink() {
        return DownloadLink;
    }

    public void setDownloadLink(String downloadLink) {
        DownloadLink = downloadLink;
    }

    public List<String> getContentTypes() {
        return ContentTypes;
    }

    public void setContentTypes(List<String> contentTypes) {
        ContentTypes = contentTypes;
    }

    public List<String> getNames() {
        return Names;
    }

    public void setNames(List<String> names) {
        Names = names;
    }
}
