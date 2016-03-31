;; =======================================
;; Arquivo de Configuração do Emacs (24.5)
;;
;; autor  : Marcelo dos Santos
;; versão : 0.9
;; url    : https://github.com/mdssjc/files/.emacs
;;          http://tuhdo.github.io/index.html
;;

;; PROXY
;(setq url-using-proxy t)
;(setq url-proxy-services '(("no_proxy" . "^\\(localhost\\|10.*\\)")
;                           ("http"     . "10.146.8.121:8080")))

;; PACKAGES
(setq package-archives '(("gnu" . "http://elpa.gnu.org/packages/")
                         ("melpa" . "http://melpa.milkbox.net/packages/")))
(setq package-list '(ac-html dash f dash s s auto-complete popup
                     ac-html magit magit-popup dash async
                     git-commit with-editor dash async dash
                     with-editor dash async dash async magit s s
                     ac-c-headers auto-complete popup
                     ac-haskell-process haskell-mode
                     auto-complete popup ac-helm popup
                     auto-complete popup helm helm-core async
                     async ac-html dash f dash s s auto-complete
                     popup ac-ispell auto-complete popup avy
                     auctex auto-complete-c-headers auto-complete
                     popup benchmark-init company-c-headers
                     company company-ghc ghc haskell-mode company
                     company-ghci haskell-mode company
                     company-irony irony company
                     company-irony-c-headers irony company
                     company-quickhelp pos-tip company
                     company-web web-completion-data dash company
                     electric-case electric-operator names dash
                     electric-spacing elpy yasnippet pyvenv
                     highlight-indentation find-file-in-project
                     company emacs-eclim s popup dash f dash s
                     fill-column-indicator find-file-in-project
                     flycheck-ghcmod dash flycheck let-alist
                     pkg-info epl dash flycheck-google-cpplint
                     flycheck let-alist pkg-info epl dash
                     flycheck-haskell let-alist dash haskell-mode
                     flycheck let-alist pkg-info epl dash
                     flycheck-hdevtools dash flycheck let-alist
                     pkg-info epl dash flycheck-irony irony
                     flycheck let-alist pkg-info epl dash
                     flycheck-pos-tip popup flycheck let-alist
                     pkg-info epl dash flycheck-tip popup
                     flycheck let-alist pkg-info epl dash
                     flymake-cppcheck flymake-easy
                     flymake-gjshint flymake-google-cpplint
                     flymake-easy flymake-haskell-multi
                     flymake-easy flymake-hlint flymake-easy
                     flymake-jshint flymake-easy flymake-jslint
                     flymake-easy flymake-shell flymake-easy
                     flyspell-lazy flyspell-popup popup
                     function-args swiper google-c-style
                     haskell-emacs haskell-snippets yasnippet
                     helm-circe circe helm helm-core async async
                     helm-cmd-t helm-company company helm
                     helm-core async async helm-emmet emmet-mode
                     helm helm-core async async helm-flycheck
                     helm helm-core async async flycheck
                     let-alist pkg-info epl dash dash
                     helm-flymake helm helm-core async async
                     helm-flyspell helm-fuzzy-find helm helm-core
                     async async helm-ghc ghc haskell-mode helm
                     helm-core async async helm-gtags helm
                     helm-core async async helm-jstack helm
                     helm-core async async helm-make projectile
                     pkg-info epl dash helm helm-core async async
                     helm-package helm helm-core async async
                     helm-projectile dash projectile pkg-info epl
                     dash helm helm-core async async highlight
                     highlight-indentation http request
                     ido-at-point ido-complete-space-or-hyphen
                     iedit irony java-snippets yasnippet
                     javadoc-lookup jdee js3-mode let-alist
                     magit-svn magit magit-popup dash async
                     git-commit with-editor dash async dash
                     with-editor dash async dash async
                     material-theme move-dup names org-ac
                     yaxception log4e auto-complete-pcmp
                     yaxception log4e auto-complete popup
                     package-safe-delete epl popup pos-tip
                     powerline projectile pkg-info epl dash
                     pyvenv request screenshot simple-httpd
                     smart-region multiple-cursors expand-region
                     smartparens dash stickyfunc-enhance swiper
                     switch-window tabbar-ruler tabbar undo-tree
                     web-completion-data which-key dash s
                     with-editor dash async yasnippet yaxception
                     ztree))
(package-initialize)
(unless package-archive-contents
  (package-refresh-contents))
(dolist (package package-list)
  (unless (package-installed-p package)
    (package-install package)))

;; GLOBAL SET KEY
;; edição e formatação
(global-set-key (kbd "<f7> 1") 'delete-trailing-whitespace)
(global-set-key (kbd "<f7> 2") 'untabify)
(global-set-key (kbd "<f7> 3") 'iedit-mode)
(global-set-key (kbd "<f7> 4") 'highlight-phrase)

;; modificação no ambiente
(global-set-key (kbd "<f8> 1") 'whitespace-mode)
(global-set-key (kbd "<f8> 2") 'visual-line-mode)
(global-set-key (kbd "<f8> 3") 'follow-mode)
(global-set-key (kbd "<f8> 4") 'package-list-packages)
(global-set-key (kbd "<f8> 5") 'customize-mode)
(global-set-key (kbd "<f8> 6") 'mds/open-emacs-config)
(global-set-key (kbd "<f8> 7") 'projectile-global-mode)

;; janela
(global-set-key (kbd "s-<left>")    'shrink-window-horizontally)
(global-set-key (kbd "s-<right>")   'enlarge-window-horizontally)
(global-set-key (kbd "s-<down>")    'shrink-window)
(global-set-key (kbd "s-<up>")      'enlarge-window)
(global-set-key (kbd "s-?")         'shrink-window-if-larger-than-buffer)
(global-set-key (kbd "C-s-<up>")    'buf-move-up)
(global-set-key (kbd "C-s-<down>")  'buf-move-down)
(global-set-key (kbd "C-s-<left>")  'buf-move-left)
(global-set-key (kbd "C-s-<right>") 'buf-move-right)
(global-set-key (kbd "C-x o")       'switch-window)

(global-set-key (kbd "M-<up>")     'md/move-lines-up)
(global-set-key (kbd "M-<down>")   'md/move-lines-down)
(global-set-key (kbd "s-M-<up>")   'md/duplicate-up)
(global-set-key (kbd "s-M-<down>") 'md/duplicate-down)

(global-set-key (kbd "s-'")        'align-regexp)
(global-set-key (kbd "C-s-'")      'align)
(global-set-key (kbd "M-1")        'cycle-spacing)
(global-set-key (kbd "C-:")        'avy-goto-char-2)
(global-set-key (kbd "C-=")        'er/expand-region)
(global-set-key (kbd "C-<return>") 'mds/insert-lines-between)

;; mouse
(global-set-key [s-mouse-2] 'dictionary-mouse-popup-matching-words)
(global-set-key [s-mouse-1] 'semantic-ia-fast-jump)

;; ENABLE MODES
(require 'powerline)
(require 'expand-region)
(require 'multiple-cursors)
(require 'cl-lib)
(require 'smartparens-config)
(require 'benchmark-init)
(require 'electric-case)

(powerline-default-theme)
(windmove-default-keybindings)
(autoload 'js3-mode "js3" nil t)
(add-to-list 'auto-mode-alist '("\\.js$" . js3-mode))

(org-babel-do-load-languages
      'org-babel-load-languages
      '((emacs-lisp . nil)
        (haskell . t)))

;; MAJOR'S MODE
(defun my:major-mode-ext()
  (require 'fill-column-indicator)
  (fci-mode)                        ; delimitador visual de colunas
  (ac-ispell-setup)
  (ac-ispell-ac-setup)
  (flyspell-mode)
  (define-key flyspell-mode-map (kbd "C-;") 'helm-flyspell-correct)
  (electric-spacing-mode)
  (ruler-mode t))                   ; régua no editor
(add-hook 'fundamental-mode-hook 'my:major-mode-ext) ; fundamental
(add-hook 'text-mode-hook        'my:major-mode-ext) ; text
(add-hook 'java-mode-hook        'my:major-mode-ext) ; java
(add-hook 'js-mode-hook          'my:major-mode-ext) ; javascript
(add-hook 'haskell-mode          'my:major-mode-ext) ; haskell
(add-hook 'python-mode-hook      'my:major-mode-ext) ; python
(add-hook 'makefile-mode-hook    'my:major-mode-ext) ; makefile
(add-hook 'sh-mode-hook          'my:major-mode-ext) ; shell-script
(add-hook 'lisp-mode-hook        'my:major-mode-ext) ; lisp
(add-hook 'emacs-lisp-mode-hook  'my:major-mode-ext) ; emacs-lisp

(add-hook 'java-mode-hook 'electric-case-java-init)

;; AUTO-COMPLETE
(ac-config-default)
(setq ac-sources '(ac-source-imenu
                   ac-source-filename
                   ac-source-functions
                   ac-source-yasnippet
                   ac-source-variables
                   ac-source-symbols
                   ac-source-features
                   ac-source-abbrev
                   ac-source-words-in-same-mode-buffers
                   ac-source-dictionary
                   ac-source-semantic
                   ac-source-ispell
                   ac-source-ispell-fuzzy))
(defun my:ac-init()
  (require 'auto-complete-c-headers)
  (add-to-list 'ac-sources 'ac-source-c-headers)
  (add-to-list 'ac-sources 'ac-source-c-header-symbols t)
  (add-to-list 'company-backends 'company-c-headers)
  (my:major-mode-ext))
(add-hook 'c-mode-hook 'my:ac-init)     ; c
(add-hook 'c++-mode-hook 'my:ac-init)   ; c++

(require 'google-c-style)
(add-hook 'c-mode-common-hook 'google-set-c-style)
(add-hook 'c-mode-common-hook 'google-make-newline-indent)
(add-hook 'c-mode-common-hook 'electric-case-c-init)
(add-hook 'c++-mode-hook      'electric-case-c-init)

;; ORG_MODE
(defun my:org-setup()
  (my:major-mode-ext))
(add-hook 'org-mode-hook 'my:org-setup)

;; TABBAR
(setq tabbar-ruler-global-ruler t)

;; CEDET
(require 'semantic)
(require 'semantic/ia)
(require 'semantic/db)
(require 'semantic/bovine)
(add-to-list 'semantic-default-submodes 'global-semantic-idle-scheduler-mode)
(add-to-list 'semantic-default-submodes 'global-semanticdb-minor-mode)
(add-to-list 'semantic-default-submodes 'global-semantic-idle-summary-mode)
(add-to-list 'semantic-default-submodes 'global-semantic-idle-completions-mode)
(add-to-list 'semantic-default-submodes 'global-semantic-highlight-func-mode)
(add-to-list 'semantic-default-submodes 'global-semantic-decoration-mode)
(add-to-list 'semantic-default-submodes 'global-semantic-stickyfunc-mode)
(add-to-list 'semantic-default-submodes 'global-semantic-mru-bookmark-mode)

(semantic-mode 1)
(semanticdb-enable-gnu-global-databases 'c-mode t)
(semanticdb-enable-gnu-global-databases 'c++-mode t)

(helm-projectile-on)

;; SMARTPARENS
;(sp-local-pair 'emacs-lisp-mode "'" nil :actions nil)

;; AUTOMATIC
(custom-set-variables
 ;; custom-set-variables was added by Custom.
 ;; If you edit it by hand, you could mess it up, so be careful.
 ;; Your init file should contain only one such instance.
 ;; If there is more than one, they won't work right.
 '(LaTeX-indent-level 4)
 '(LaTeX-item-indent 0)
 '(TeX-brace-indent-level 4)
 '(ac-ispell-requires 2)
 '(c-default-style
   (quote
    ((c-mode . "cc-mode")
     (c++-mode . "cc-mode")
     (java-mode . "java")
     (awk-mode . "awk")
     (other . "gnu"))))
 '(column-number-mode t)
 '(comment-auto-fill-only-comments t)
 '(company-show-numbers t)
 '(company-tooltip-align-annotations t)
 '(delete-selection-mode t)
 '(display-time-mode nil)
 '(electric-layout-mode t)
 '(electric-pair-inhibit-predicate (quote electric-pair-default-inhibit))
 '(electric-pair-mode t)
 '(electric-pair-pairs (quote ((34 . 34) (39 . 39) (40 . 41) (123 . 125))))
 '(electric-pair-text-pairs (quote ((34 . 34) (39 . 39))))
 '(electric-spacing-double-space-docs nil)
 '(fill-column 79)
 '(global-auto-complete-mode t)
 '(global-company-mode t)
 '(global-flycheck-mode t)
 '(global-hl-line-mode t)
 '(global-linum-mode t)
 '(global-move-dup-mode t)
 '(global-undo-tree-mode t)
 '(helm-adaptive-mode t nil (helm-adaptive))
 '(helm-mode t)
 '(ido-everywhere t)
 '(ido-mode (quote both) nil (ido))
 '(indent-tabs-mode nil)
 '(inhibit-startup-screen t)
 '(ispell-dictionary "brasileiro")
 '(ispell-extra-args (quote ("--sug-mode=ultra")))
 '(js3-auto-indent-p t)
 '(js3-enter-indents-newline t)
 '(js3-indent-on-enter-key t)
 '(mouse-avoidance-mode (quote animate) nil (avoid))
 '(next-line-add-newlines nil)
 '(org-completion-use-ido t)
 '(org-export-with-section-numbers nil)
 '(org-export-with-toc nil)
 '(org-todo-keyword-faces
   (quote
    (("TODO" . "red1")
     ("DONE" . "forestgreen")
     ("PASS" . "forestgreen")
     ("FAIL" . "red1")
     ("FEEDBACK" . "blue1")
     ("VERIFY" . "blue1")
     ("DELEGATED" . "blue1")
     ("WAIT" . "blue1"))))
 '(org-todo-keywords
   (quote
    ((sequence "TODO" "DONE" "PASS" "FAIL" "FEEDBACK" "VERIFY" "DELEGATED" "WAIT"))))
 '(package-archives
   (quote
    (("gnu" . "http://elpa.gnu.org/packages/")
     ("melpa" . "http://melpa.milkbox.net/packages/"))))
 '(projectile-completion-system (quote helm))
 '(projectile-enable-caching t)
 '(projectile-enable-idle-timer nil)
 '(projectile-project-root-files
   (quote
    ("Makefile" "rebar.config" "project.clj" "SConstruct" "pom.xml" "build.sbt" "build.gradle" "Gemfile" "requirements.txt" "setup.py" "tox.ini" "package.json" "gulpfile.js" "Gruntfile.js" "bower.json" "composer.json" "Cargo.toml" "mix.exs" "stack.yaml")))
 '(projectile-switch-project-action (quote helm-projectile-find-file))
 '(recentf-mode t)
 '(require-final-newline t)
 '(semantic-c-dependency-system-include-path (quote ("/usr/include")))
 '(show-paren-mode t)
 '(show-smartparens-global-mode t)
 '(show-trailing-whitespace t)
 '(smartparens-global-mode t)
 '(smartparens-global-strict-mode t)
 '(sp-autoinsert-quote-if-followed-by-closing-pair t)
 '(sp-undo-pairs-separately t)
 '(sp-wrap-from-point t)
 '(tab-width 4)
 '(tabbar-mode t nil (tabbar))
 '(tabbar-mwheel-mode t nil (tabbar))
 '(which-function-mode t)
 '(which-key-mode t)
 '(which-key-show-remaining-keys t)
 '(winner-mode t)
 '(yas-global-mode t nil (yasnippet)))
(custom-set-faces
 ;; custom-set-faces was added by Custom.
 ;; If you edit it by hand, you could mess it up, so be careful.
 ;; Your init file should contain only one such instance.
 ;; If there is more than one, they won't work right.
 '(cursor ((t (:background "royal blue"))))
 '(show-paren-match ((t (:background "gainsboro"))))
 '(show-paren-mismatch ((t (:background "red" :foreground "white")))))

;; MINHAS FUNÇÕES (lib mds)
(defun mds/insert-lines-between(times)
  "Insere uma quebra de linhas entre o local do cursor."
  (interactive "p")
  (save-excursion
    (beginning-of-line)
    (newline times)
    (end-of-line)
    (newline times)))

(defun mds/open-emacs-config()
  "Abre o arquivo de configuração principal do Emacs."
  (interactive)
  (find-file "~/.emacs"))

;;
;; ARQUIVOS el
;;


;;; BUFFER-MOVE
;;; buffer-move.el
(require 'windmove)


(defconst buffer-move-version "0.6.1"
  "Version of buffer-move.el")

(defgroup buffer-move nil
  "Swap buffers without typing C-x b on each window"
  :group 'tools)

(defcustom buffer-move-behavior 'swap
  "If set to 'swap (default), the buffers will be exchanged
  (i.e. swapped), if set to 'move, the current window is switch back to the
  previously displayed buffer (i.e. the buffer is moved)."
  :group 'buffer-move
  :type 'symbol)


(defun buf-move-to (direction)
  "Helper function to move the current buffer to the window in the given
   direction (with must be 'up, 'down', 'left or 'right). An error is
   thrown, if no window exists in this direction."
  (let* ((other-win (windmove-find-other-window direction))
         (buf-this-buf (window-buffer (selected-window))))

    (if (null other-win)
        (error "No window in this direction")
      (if (window-dedicated-p other-win)
      (error "The window in this direction is dedicated"))
      (if (string-match "^ \\*Minibuf" (buffer-name (window-buffer other-win)))
      (error "The window in this direction is the Minibuf"))
      (if (eq buffer-move-behavior 'move)
          ;; switch selected window to previous buffer (moving)
          (switch-to-prev-buffer (selected-window))

        ;; switch selected window to buffer of other window (swapping)
        (set-window-buffer (selected-window) (window-buffer other-win))
        )

      ;; switch other window to this buffer
      (set-window-buffer other-win buf-this-buf)

      (select-window other-win))))

;;;###autoload
(defun buf-move-up ()
  "Swap the current buffer and the buffer above the split.
   If there is no split, ie now window above the current one, an
   error is signaled."
  ;;  "Switches between the current buffer, and the buffer above the
  ;;  split, if possible."
  (interactive)
  (buf-move-to 'up))

;;;###autoload
(defun buf-move-down ()
  "Swap the current buffer and the buffer under the split.
   If there is no split, ie now window under the current one, an
   error is signaled."
  (interactive)
  (buf-move-to 'down))

;;;###autoload
(defun buf-move-left ()
  "Swap the current buffer and the buffer on the left of the split.
   If there is no split, ie now window on the left of the current
   one, an error is signaled."
  (interactive)
  (buf-move-to 'left))

;;;###autoload
(defun buf-move-right ()
  "Swap the current buffer and the buffer on the right of the split.
   If there is no split, ie now window on the right of the current
   one, an error is signaled."
  (interactive)
  (buf-move-to 'right))


(provide 'buffer-move)
;;; buffer-move.el ends here
