package com.partyguham.admin.version.controller;

import com.partyguham.admin.version.VersionEntity;
import com.partyguham.admin.version.VersionService;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/admin/versions")
@RequiredArgsConstructor
public class VersionViewController {

    private final VersionService versionService;

    @GetMapping
    public String list(@PageableDefault(size = 10) Pageable pageable, Model model) {
        Page<VersionEntity> versions = versionService.getAll(pageable);
        model.addAttribute("versions", versions);
        return "admin/version/list";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("version", new VersionEntity());
        return "admin/version/form";
    }

    @PostMapping
    public String create(@ModelAttribute VersionEntity version) {
        versionService.create(version);
        return "redirect:/admin/versions";
    }

    @GetMapping("/{id}/edit")
    public String editForm(@PathVariable Long id, Model model) {
        VersionEntity version = versionService.getById(id)
                .orElseThrow(() -> new IllegalArgumentException("존재하지 않는 버전입니다."));
        model.addAttribute("version", version);
        return "admin/version/form";
    }

    @PostMapping("/{id}")
    public String update(@PathVariable Long id, @ModelAttribute VersionEntity version) {
        versionService.update(id, version);
        return "redirect:/admin/versions";
    }

    @PostMapping("/{id}/delete")
    public String delete(@PathVariable Long id) {
        versionService.delete(id);
        return "redirect:/admin/versions";
    }
}